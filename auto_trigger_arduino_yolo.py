import cv2
import numpy as np
import mss
import time
import sys
import threading
import ctypes
import winsound
import random
import os
import math
import serial # pip install pyserial
from ultralytics import YOLO

# -----------------------------------------------------------------------------
# CONFIGURACIÓN ARDUINO
# -----------------------------------------------------------------------------
ARDUINO_PORT = 'COM3' # <--- CAMBIAR ESTO POR TU PUERTO COM
BAUD_RATE = 115200

try:
    arduino = serial.Serial(ARDUINO_PORT, BAUD_RATE, timeout=0.01)
    print(f"[ARDUINO] Conectado en {ARDUINO_PORT}")
except Exception as e:
    print(f"[ERROR] No se pudo conectar al Arduino en {ARDUINO_PORT}: {e}")
    print("Asegúrate de que está conectado y el puerto es correcto.")
    arduino = None

# ... (Rest of imports and config same as before) ...
# But modifying the input functions

# -----------------------------------------------------------------------------
# CONFIGURACIÓN DE PANTALLA Y SISTEMA
# -----------------------------------------------------------------------------
try:
    ctypes.windll.shcore.SetProcessDpiAwareness(2)
except Exception:
    pass

user32 = ctypes.windll.user32
VK_N_SPANISH = 0xC0   # Tecla 'Ñ'

def disparo_tactico():
    """Envía comando de clic al Arduino"""
    if arduino and arduino.is_open:
        arduino.write(b'C\n')

# -----------------------------------------------------------------------------
# LÓGICA DE IA (YOLOv8 + MSS)
# -----------------------------------------------------------------------------
def mover_mouse_relativo(dx, dy):
    """Envía comando de movimiento al Arduino"""
    if arduino and arduino.is_open:
        cmd = f"M{int(dx)},{int(dy)}\n"
        arduino.write(cmd.encode())

# -----------------------------------------------------------------------------
# CONFIGURACIÓN
# -----------------------------------------------------------------------------
MODO_ENTRENAMIENTO = False # FALSE = YOLO

class DetectorIA:
    def __init__(self):
        self.fov_size = 320 
        self.conf_threshold = 0.30 
        
        # Acumuladores para movimiento suave (Sub-pixel)
        self.accum_x = 0.0
        self.accum_y = 0.0
        
        if not MODO_ENTRENAMIENTO:
            print("[IA] Cargando modelo YOLOv8 Nano (Optimizado)...")
            self.model = YOLO("yolov8n.pt") 
        else:
            print("[SISTEMA] MODO ENTRENAMIENTO (Aim Trainer) ACTIVADO")

        self.sct = mss.mss()
        self.ancho_pantalla = user32.GetSystemMetrics(0)
        self.alto_pantalla = user32.GetSystemMetrics(1)
        self.center_x = self.ancho_pantalla // 2
        self.center_y = self.alto_pantalla // 2
        
        self.monitor = {
            "top": self.center_y - (self.fov_size // 2),
            "left": self.center_x - (self.fov_size // 2),
            "width": self.fov_size,
            "height": self.fov_size
        }
        
        # Variables para asincronía
        self.lock = threading.Lock()
        self.latest_img = None
        self.latest_boxes = [] 
        self.running = True
        
        # Hilo de inferencia dedicado
        self.t_inferencia = threading.Thread(target=self._inference_loop)
        self.t_inferencia.daemon = True
        self.t_inferencia.start()
        

    def _inference_loop(self):
        """Hilo que corre la IA lo más rápido posible sin bloquear la vista"""
        while self.running:
            img_to_process = None
            with self.lock:
                if self.latest_img is not None:
                    img_to_process = self.latest_img.copy()
            
            if img_to_process is None:
                time.sleep(0.01)
                continue

            mis_cajas = []
            
            # LÓGICA DE JUEGO (YOLO IA)
            results = self.model.predict(img_to_process, classes=[0], conf=self.conf_threshold, 
                                       imgsz=320, verbose=False, half=False)
            if len(results[0].boxes) > 0:
                 mis_cajas = results[0].boxes.xyxy.cpu().numpy().tolist()

            with self.lock:
                self.latest_boxes = mis_cajas

    def es_enemigo_por_color(self, img_roi):
        if MODO_ENTRENAMIENTO: return True
        hsv = cv2.cvtColor(img_roi, cv2.COLOR_BGR2HSV)
        mask1 = cv2.inRange(hsv, np.array([0, 100, 100]), np.array([10, 255, 255]))
        mask2 = cv2.inRange(hsv, np.array([170, 100, 100]), np.array([180, 255, 255]))
        mask3 = cv2.inRange(hsv, np.array([130, 100, 100]), np.array([160, 255, 255]))
        mask4 = cv2.inRange(hsv, np.array([20, 100, 100]), np.array([35, 255, 255]))
        mask = mask1 | mask2 | mask3 | mask4
        return cv2.countNonZero(mask) > 5

    def procesar_frame(self, debug=False):
        screenshot = self.sct.grab(self.monitor)
        img = np.array(screenshot)
        img = img[:, :, :3] 
        
        with self.lock:
            self.latest_img = img

        target_found = False
        detecciones = self.latest_boxes
        
        annotated_frame = None
        if debug:
            annotated_frame = img.copy()
            mid = self.fov_size // 2
            cv2.rectangle(annotated_frame, (mid-2, mid-2), (mid+2, mid+2), (0, 255, 0), 2)
            estado = "HARDWARE ON" if EJECUTANDO else "ESPERA"
            cv2.putText(annotated_frame, estado, (10, 20), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0,0,255) if EJECUTANDO else (0,255,255), 2)

        if detecciones:
            mid = self.fov_size // 2
            mejor_enemigo = None
            menor_distancia = 9999
            
            for box in detecciones:
                x1, y1, x2, y2 = map(int, box[:4])
                
                # FILTRADO: Arma propia
                if y2 >= self.fov_size - 5: 
                    continue
                
                roi = img[y1:y2, x1:x2]
                if roi.size == 0 or not self.es_enemigo_por_color(roi):
                    continue
                
                cx = (x1 + x2) // 2
                cy = (y1 + y2) // 2
                dist = math.sqrt((cx - mid)**2 + (cy - mid)**2)
                
                if dist < menor_distancia:
                    menor_distancia = dist
                    mejor_enemigo = (x1, y1, x2, y2, cx, cy)
            
            if mejor_enemigo:
                x1, y1, x2, y2, cx, cy = mejor_enemigo
                
                if debug and annotated_frame is not None:
                    cv2.rectangle(annotated_frame, (x1, y1), (x2, y2), (0, 0, 255), 2)
                    cv2.line(annotated_frame, (mid, mid), (cx, cy), (0, 0, 255), 1)

                if EJECUTANDO:
                    dx = cx - mid
                    dy = cy - mid 
                    dist = math.hypot(dx, dy)
                    
                    # CURVA HYBRID ASSIST
                    factor_dist = min(dist, 60.0) / 60.0 
                    speed_factor = 0.25 + (factor_dist * 0.30)
                    
                    step_x = dx * speed_factor
                    step_y = dy * speed_factor
                    
                    LIMIT = 12.0
                    step_x = max(-LIMIT, min(LIMIT, step_x))
                    step_y = max(-LIMIT, min(LIMIT, step_y))
                    
                    self.accum_x += step_x
                    self.accum_y += step_y
                    
                    move_x = int(self.accum_x)
                    move_y = int(self.accum_y)
                    
                    self.accum_x -= move_x
                    self.accum_y -= move_y
                    
                    if move_x != 0 or move_y != 0:
                       mover_mouse_relativo(move_x, move_y)

                if (x1 < mid < x2) and (y1 < mid < y2):
                    self.accum_x = 0 
                    self.accum_y = 0
                    target_found = True

        if debug and annotated_frame is not None:
            cv2.imshow("ARDUINO IA VISION", annotated_frame)
            cv2.waitKey(1)

        return target_found

# -----------------------------------------------------------------------------
# CONTROL PRINCIPAL
# -----------------------------------------------------------------------------
EJECUTANDO = False
PROGRAMA_ACTIVO = True
DEBUG_VISUAL = True

def tarea_ia():
    global EJECUTANDO
    detector = DetectorIA()
    print(f"\n[IA] Sistema Listo. FOV: {detector.fov_size}x{detector.fov_size}")
    
    ultimo_disparo = 0
    cooldown = 0.18
    
    while PROGRAMA_ACTIVO:
        try:
            start_time = time.time()
            encontrado = detector.procesar_frame(debug=DEBUG_VISUAL)
            
            if EJECUTANDO and encontrado and (time.time() - ultimo_disparo > cooldown):
                disparo_tactico()
                print(f"[HW DISPARO!] Enemigo detectado") 
                ultimo_disparo = time.time()
        except Exception as e:
            print(f"Error frame: {e}")
        
        if not EJECUTANDO:
            time.sleep(0.01)
        else:
            pass

def tarea_hotkeys():
    global EJECUTANDO, PROGRAMA_ACTIVO
    print("\n[INFO] Mantén 'Ñ' para activar HW Assist.")
    while PROGRAMA_ACTIVO:
        estado_n = user32.GetAsyncKeyState(VK_N_SPANISH)
        if estado_n & 0x8000:
            EJECUTANDO = True
        else:
            EJECUTANDO = False
        time.sleep(0.01)

def iniciar():
    global PROGRAMA_ACTIVO
    os.system('cls' if os.name == 'nt' else 'clear')
    print("=== AUTO TRIGGER ARDUINO - JUEGO (YOLO) ===")
    
    t_keys = threading.Thread(target=tarea_hotkeys)
    t_keys.daemon = True
    t_keys.start()
    
    t_ia = threading.Thread(target=tarea_ia)
    t_ia.daemon = True
    t_ia.start()
    
    while True:
        try:
            cmd = input().strip().lower()
            if cmd == "salir":
                PROGRAMA_ACTIVO = False
                break
        except:
            break

if __name__ == "__main__":
    iniciar()
