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
from ultralytics import YOLO

# -----------------------------------------------------------------------------
# CONFIGURACIÓN DE PANTALLA Y SISTEMA
# -----------------------------------------------------------------------------
try:
    ctypes.windll.shcore.SetProcessDpiAwareness(2)
except Exception:
    pass

# -----------------------------------------------------------------------------
# MOTOR DE INPUT (SCANCODES PUROS)
# -----------------------------------------------------------------------------
user32 = ctypes.windll.user32

PUL = ctypes.POINTER(ctypes.c_ulong)
class KeyBdInput(ctypes.Structure):
    _fields_ = [("wVk", ctypes.c_ushort), ("wScan", ctypes.c_ushort), ("dwFlags", ctypes.c_ulong), ("time", ctypes.c_ulong), ("dwExtraInfo", PUL)]
class HardwareInput(ctypes.Structure):
    _fields_ = [("uMsg", ctypes.c_ulong), ("wParamL", ctypes.c_short), ("wParamH", ctypes.c_ushort)]
class MouseInput(ctypes.Structure):
    _fields_ = [("dx", ctypes.c_long), ("dy", ctypes.c_long), ("mouseData", ctypes.c_ulong), ("dwFlags", ctypes.c_ulong), ("time", ctypes.c_ulong), ("dwExtraInfo", PUL)]
class Input_I(ctypes.Union):
    _fields_ = [("ki", KeyBdInput), ("mi", MouseInput), ("hi", HardwareInput)]
class Input(ctypes.Structure):
    _fields_ = [("type", ctypes.c_ulong), ("ii", Input_I)]

# Scancodes físicos
SCANCODE_9_TOP = 0x0A # Tecla '9'
VK_N_SPANISH = 0xC0   # Tecla 'Ñ'

def enviar_tecla_scancode(scancode):
    extra = ctypes.c_ulong(0)
    # DOWN
    ii_down = Input_I()
    ii_down.ki = KeyBdInput(0, scancode, 0x0008, 0, ctypes.pointer(extra))
    x_down = Input(ctypes.c_ulong(1), ii_down)
    user32.SendInput(1, ctypes.pointer(x_down), ctypes.sizeof(x_down))

    # RECUPERACIÓN (Recoil control simplificado)
    time.sleep(random.uniform(0.02, 0.05))

def disparo_tactico():
    """Simula clic izquierdo del mouse"""
    extra = ctypes.c_ulong(0)
    ii_down = Input_I()
    ii_down.mi = MouseInput(0, 0, 0, 0x0002, 0, ctypes.pointer(extra)) # Left Down
    x_down = Input(ctypes.c_ulong(0), ii_down)
    user32.SendInput(1, ctypes.pointer(x_down), ctypes.sizeof(x_down))
    
    time.sleep(random.uniform(0.01, 0.03))
    
    ii_up = Input_I()
    ii_up.mi = MouseInput(0, 0, 0, 0x0004, 0, ctypes.pointer(extra)) # Left Up
    x_up = Input(ctypes.c_ulong(0), ii_up)
    user32.SendInput(1, ctypes.pointer(x_up), ctypes.sizeof(x_up))

# -----------------------------------------------------------------------------
# LÓGICA DE IA (YOLOv8 + MSS)
# -----------------------------------------------------------------------------
def mover_mouse_relativo(dx, dy):
    extra = ctypes.c_ulong(0)
    # MOUSEEVENTF_MOVE = 0x0001
    ii = Input_I()
    ii.mi = MouseInput(int(dx), int(dy), 0, 0x0001, 0, ctypes.pointer(extra))
    cp = Input(ctypes.c_ulong(0), ii) 
    user32.SendInput(1, ctypes.pointer(cp), ctypes.sizeof(cp))

# -----------------------------------------------------------------------------
# CONFIGURACIÓN
# -----------------------------------------------------------------------------
MODO_ENTRENAMIENTO = False # FALSE = MODO JUEGO (YOLO PERSONAS)

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
            print("Detectando objetivos: ROJO, CYAN, NARANJA")

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

            if MODO_ENTRENAMIENTO:
                # --- LÓGICA DE AIM TRAINER (ESFERA AZUL) ---
                pass # No se usa aquí
            
            else:
                # --- LÓGICA DE JUEGO (YOLO IA) ---
                results = self.model.predict(img_to_process, classes=[0], conf=self.conf_threshold, 
                                           imgsz=320, verbose=False, half=False)
                # Extraer cajas en formato Numpy directo
                if len(results[0].boxes) > 0:
                     mis_cajas = results[0].boxes.xyxy.cpu().numpy().tolist()

            with self.lock:
                self.latest_boxes = mis_cajas

    def es_enemigo_por_color(self, img_roi):
        # En modo entrenamiento, asumimos que si el detector de color lo vio, ES válido.
        if MODO_ENTRENAMIENTO: return True

        hsv = cv2.cvtColor(img_roi, cv2.COLOR_BGR2HSV)
        mask1 = cv2.inRange(hsv, np.array([0, 100, 100]), np.array([10, 255, 255]))
        mask2 = cv2.inRange(hsv, np.array([170, 100, 100]), np.array([180, 255, 255]))
        mask3 = cv2.inRange(hsv, np.array([130, 100, 100]), np.array([160, 255, 255]))
        mask4 = cv2.inRange(hsv, np.array([20, 100, 100]), np.array([35, 255, 255]))
        mask = mask1 | mask2 | mask3 | mask4
        return cv2.countNonZero(mask) > 5

    def procesar_frame(self, debug=False):
        # 1. Captura (ALTA VELOCIDAD)
        screenshot = self.sct.grab(self.monitor)
        img = np.array(screenshot)
        img = img[:, :, :3] 
        
        # Actualizar imagen para el hilo de IA
        with self.lock:
            self.latest_img = img

        target_found = False
        
        # Usar las ÚLTIMAS detecciones disponibles (pueden ser del frame anterior)
        detecciones = self.latest_boxes
        
        # Debug Frame
        annotated_frame = None
        if debug:
            annotated_frame = img.copy()
            mid = self.fov_size // 2
            cv2.rectangle(annotated_frame, (mid-2, mid-2), (mid+2, mid+2), (0, 255, 0), 2)
            estado = "ACTIVADO" if EJECUTANDO else "ESPERA"
            cv2.putText(annotated_frame, estado, (10, 20), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0,0,255) if EJECUTANDO else (0,255,255), 2)

        if detecciones:
            mid = self.fov_size // 2
            mejor_enemigo = None
            menor_distancia = 9999
            
            for box in detecciones:
                x1, y1, x2, y2 = map(int, box[:4])
                
                # FILTRADO: Arma propia (Solo en modo persona)
                if not MODO_ENTRENAMIENTO and y2 >= self.fov_size - 5: # Arma propia
                    if debug and annotated_frame is not None: 
                        cv2.rectangle(annotated_frame, (x1, y1), (x2, y2), (255, 0, 0), 2)
                    continue
                
                # Visualización básica
                if debug and annotated_frame is not None:
                     cv2.rectangle(annotated_frame, (x1, y1), (x2, y2), (0, 255, 255), 1)

                roi = img[y1:y2, x1:x2]
                if roi.size == 0 or not self.es_enemigo_por_color(roi):
                    if debug and annotated_frame is not None: 
                        cv2.rectangle(annotated_frame, (x1, y1), (x2, y2), (0, 255, 255), 2)
                    continue
                
                # Calcular centro enemigo
                cx = (x1 + x2) // 2
                cy = (y1 + y2) // 2
                
                # Solo nos interesa si está CERCA del centro (Aim FOV 100px aprox)
                dist = math.sqrt((cx - mid)**2 + (cy - mid)**2)
                
                if dist < menor_distancia:
                    menor_distancia = dist
                    mejor_enemigo = (x1, y1, x2, y2, cx, cy)
            
            # --- LÓGICA DE TARGET VALIDADO ---
            if mejor_enemigo:
                x1, y1, x2, y2, cx, cy = mejor_enemigo
                
                # Visualizar target elegido
                if debug and annotated_frame is not None:
                    cv2.rectangle(annotated_frame, (x1, y1), (x2, y2), (0, 0, 255), 2)
                    cv2.line(annotated_frame, (mid, mid), (cx, cy), (0, 0, 255), 1)

                # AIM ASSIST (HUMANIZADO: Flick Rápido + Micro-ajuste)
                if EJECUTANDO:
                    # Distancia real al centro
                    dx = cx - mid
                    dy = cy - mid 
                    dist = math.hypot(dx, dy)
                    
                    # CURVA "HYBRID ASSIST" (Suave y respetuosa)
                    # 25% Base -> 55% Max
                    # Diseñada para "empujar" sin pelear contra tu mano.
                    
                    factor_dist = min(dist, 60.0) / 60.0 
                    speed_factor = 0.25 + (factor_dist * 0.30)
                    
                    step_x = dx * speed_factor
                    step_y = dy * speed_factor
                    
                    # LIMITADOR DE FUERZA (Anti-Fight)
                    # Nunca mueve más de 12 píxeles por frame para que tu mano mande.
                    LIMIT = 12.0
                    step_x = max(-LIMIT, min(LIMIT, step_x))
                    step_y = max(-LIMIT, min(LIMIT, step_y))
                    
                    # Acumular residuos (Sub-pixel movement)
                    self.accum_x += step_x
                    self.accum_y += step_y
                    
                    move_x = int(self.accum_x)
                    move_y = int(self.accum_y)
                    
                    self.accum_x -= move_x
                    self.accum_y -= move_y
                    
                    if move_x != 0 or move_y != 0:
                       mover_mouse_relativo(move_x, move_y)

                # TRIGGER (Disparo)
                if (x1 < mid < x2) and (y1 < mid < y2):
                    self.accum_x = 0 
                    self.accum_y = 0
                    target_found = True

        if debug and annotated_frame is not None:
            cv2.imshow("IA VISION - ESC", annotated_frame)
            cv2.waitKey(1)

        return target_found

# -----------------------------------------------------------------------------
# CONTROL PRINCIPAL
# -----------------------------------------------------------------------------
EJECUTANDO = False
PROGRAMA_ACTIVO = True
DEBUG_VISUAL = True # Activado por defecto para probar

def tarea_ia():
    global EJECUTANDO
    detector = DetectorIA()
    print(f"\n[IA] Sistema Listo. FOV: {detector.fov_size}x{detector.fov_size}")
    print("[IA] Ventana de visión abierta para depuración.")
    
    ultimo_disparo = 0
    cooldown = 0.18 # Tiempo entre disparos
    
    while PROGRAMA_ACTIVO:
        # SIEMPRE procesamos frame para ver la ventana
        try:
            start_time = time.time()
            
            # Buscar objetivo
            # Pasar flag de debug
            encontrado = detector.procesar_frame(debug=DEBUG_VISUAL)
            
            # Solo disparamos si está activado
            if EJECUTANDO and encontrado and (time.time() - ultimo_disparo > cooldown):
                disparo_tactico()
                print(f"[DISPARO!] Enemigo detectado en la mira") 
                ultimo_disparo = time.time()
        except Exception as e:
            print(f"Error frame: {e}")
        
        # Pequeña pausa para no quemar CPU si no hace falta
        # Pequeña pausa SOLO si no está activo para salvar CPU
        # Si está activo, corre a máximos FPS posibles
        if not EJECUTANDO:
            time.sleep(0.01)
        else:
            # Control de estabilidad (0.0ms delay = máxima velocidad)
            pass

def tarea_hotkeys():
    global EJECUTANDO, PROGRAMA_ACTIVO
    print("\n[INFO] Mantén presionada la tecla 'Ñ' para activar.")
    print("[INFO] Escribe 'salir' en la consola para cerrar.")
    
    while PROGRAMA_ACTIVO:
        # 0x8000 es el bit que indica si la tecla está presionada en este instante
        estado_n = user32.GetAsyncKeyState(VK_N_SPANISH)
        
        if estado_n & 0x8000:
            EJECUTANDO = True
        else:
            EJECUTANDO = False
            
        time.sleep(0.01)

def iniciar():
    global PROGRAMA_ACTIVO
    os.system('cls' if os.name == 'nt' else 'clear')
    
    print("=== AUTO TRIGGER IA (YOLOv8) ===")
    
    # Iniciar hilos
    t_keys = threading.Thread(target=tarea_hotkeys)
    t_keys.daemon = True
    t_keys.start()
    
    t_ia = threading.Thread(target=tarea_ia)
    t_ia.daemon = True
    t_ia.start()
    
    # Loop principal para comandos de consola
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
