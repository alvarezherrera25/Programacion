import pyautogui
import time
import sys
import threading
import ctypes
import math
import winsound
import random
import os

# -----------------------------------------------------------------------------
# CONFIGURACIÓN DE PANTALLA
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
SCANCODE_9_TOP = 0x0A    
VK_N_SPANISH = 0xC0      

def enviar_tecla_scancode(scancode):
    extra = ctypes.c_ulong(0)
    # DOWN
    ii_down = Input_I()
    ii_down.ki = KeyBdInput(0, scancode, 0x0008, 0, ctypes.pointer(extra))
    x_down = Input(ctypes.c_ulong(1), ii_down)
    user32.SendInput(1, ctypes.pointer(x_down), ctypes.sizeof(x_down))

    # TIEMPO DE PULSACIÓN ULTRACORTO (PRECISIÓN)
    # Entre 30ms y 60ms para evitar recoil
    time.sleep(random.uniform(0.03, 0.06))

    # UP
    ii_up = Input_I()
    ii_up.ki = KeyBdInput(0, scancode, 0x0008 | 0x0002, 0, ctypes.pointer(extra))
    x_up = Input(ctypes.c_ulong(1), ii_up)
    user32.SendInput(1, ctypes.pointer(x_up), ctypes.sizeof(x_up))

def presionar_9_tap():
    """Disparo de precisión única"""
    enviar_tecla_scancode(SCANCODE_9_TOP)

# -----------------------------------------------------------------------------
# LECTURA DE PANTALLA (GDI)
# -----------------------------------------------------------------------------
gdi32 = ctypes.windll.gdi32

def obtener_pixel_gdi(x, y):
    hdc = user32.GetDC(0)
    pixel = gdi32.GetPixel(hdc, x, y)
    user32.ReleaseDC(0, hdc)
    red = pixel & 0xFF
    green = (pixel >> 8) & 0xFF
    blue = (pixel >> 16) & 0xFF
    return (red, green, blue)

def dibujar_cuadro_rojo(x, y, radio):
    hdc = user32.GetDC(0)
    color = 0x0000FF 
    for i in range(x - radio, x + radio): gdi32.SetPixel(hdc, i, y - radio, color)
    for i in range(x - radio, x + radio): gdi32.SetPixel(hdc, i, y + radio, color)
    for i in range(y - radio, y + radio): gdi32.SetPixel(hdc, x - radio, i, color)
    for i in range(y - radio, y + radio): gdi32.SetPixel(hdc, x + radio, i, color)
    user32.ReleaseDC(0, hdc)

# -----------------------------------------------------------------------------
# LÓGICA PRINCIPAL - MODO FRANCOTIRADOR
# -----------------------------------------------------------------------------
# RADIO REDUCIDO AL MÍNIMO PARA MÁXIMA PRECISIÓN
RADIO_ESCANEO = 1         # Solo 1 pixel alrededor del centro (Matriz de 3x3 píxeles total)
OFFSET_Y_DEFAULT = 0      # Centro exacto
offset_actual = OFFSET_Y_DEFAULT 

EJECUTANDO = False      
PROGRAMA_ACTIVO = True  
OBJETIVO_COLOR = None     
TOLERANCIA = 55           # Tolerancia ajustada a 55
SONIDO_ACTIVADO = True    

def calcular_distancia_color(c1, c2):
    return math.sqrt((c1[0] - c2[0])**2 + (c1[1] - c2[1])**2 + (c1[2] - c2[2])**2)

def es_perfil_valorant(r, g, b):
    # Lógica endurecida:
    # 1. Debe ser bastante brillante (R y B > 140)
    if r < 140 or b < 140: return False
    # 2. La diferencia con el verde debe ser muy clara (> 35)
    # Esto evita disparar a paredes ligeramente lilas o sombras.
    return (r > g + 35) and (b > g + 35)

def buscar_en_area_gdi(centro_x, zona_y):
    # Al ser un radio tan pequeño (1), revisamos cada píxel sin saltos
    for x in range(centro_x - RADIO_ESCANEO, centro_x + RADIO_ESCANEO + 1):
        for y in range(zona_y - RADIO_ESCANEO, zona_y + RADIO_ESCANEO + 1):
            r, g, b = obtener_pixel_gdi(x, y)
            
            if OBJETIVO_COLOR:
                if calcular_distancia_color((r,g,b), OBJETIVO_COLOR) < TOLERANCIA:
                    return True, (r,g,b)
            else:
                if es_perfil_valorant(r, g, b):
                    return True, (r,g,b)
    return False, None

def tarea_escanear(centro_x, centro_y):
    global EJECUTANDO
    zona_y = centro_y + offset_actual
    print(f"\n[Sistema] MODO PRECISIÓN EXTREMA (Radio {RADIO_ESCANEO}px).")
    ultimo_disparo = 0
    cooldown = 0.15 

    while PROGRAMA_ACTIVO:
        if EJECUTANDO:
            try:
                encontrado, color = buscar_en_area_gdi(centro_x, zona_y)

                if encontrado and (time.time() - ultimo_disparo > cooldown):
                    presionar_9_tap()
                    if SONIDO_ACTIVADO: winsound.Beep(3500, 5) # Beep más agudo y corto
                    ultimo_disparo = time.time()
            except Exception:
                pass
        
        # Loop ultrarrápido
        time.sleep(0.0005) 

def tarea_hotkeys():
    global EJECUTANDO, PROGRAMA_ACTIVO
    n_presionada = False
    while PROGRAMA_ACTIVO:
        estado_n = user32.GetAsyncKeyState(VK_N_SPANISH)
        if (estado_n & 0x8000) and not n_presionada:
            n_presionada = True
            EJECUTANDO = not EJECUTANDO
            if EJECUTANDO:
                print("\n[ON]")
                winsound.Beep(1500, 50) 
            else:
                print("\n[OFF]")
                winsound.Beep(500, 50)  
        elif not (estado_n & 0x8000):
            n_presionada = False
        time.sleep(0.01)

def monitor_mouse():
    print("\n--- MONITOR DE PRECISIÓN ---")
    print("Mueve el mouse. [Ctrl+C] para salir.")
    try:
        while True:
            x, y = pyautogui.position()
            color = obtener_pixel_gdi(x, y)
            match_txt = "NO"
            if OBJETIVO_COLOR:
                dist = calcular_distancia_color(color, OBJETIVO_COLOR)
                if dist < TOLERANCIA: match_txt = f"SÍ (Dist: {dist:.1f})"
            elif es_perfil_valorant(color[0], color[1], color[2]):
                match_txt = "SÍ (Auto)"
            print(f"\rMouse ({x}, {y}) RGB: {color} | Match: {match_txt}      ", end="")
            time.sleep(0.05)
    except KeyboardInterrupt:
        print("\nMonitor finalizado.")

def dibujar_guia(centro_x, centro_y):
    print("\nDibujando PUNTO central...")
    zona_y = centro_y + offset_actual
    start = time.time()
    while time.time() - start < 5:
        dibujar_cuadro_rojo(centro_x, zona_y, RADIO_ESCANEO)
        time.sleep(0.05)
    print("Fin.\n")

def prueba_input():
    print("\n[TEST] 3 segundos para el chat...")
    time.sleep(3)
    for i in range(3):
        presionar_9_tap()
        time.sleep(0.1)
    print("Hecho.")

def iniciar():
    global EJECUTANDO, SONIDO_ACTIVADO, OBJETIVO_COLOR, offset_actual, TOLERANCIA, PROGRAMA_ACTIVO
    os.system('cls' if os.name == 'nt' else 'clear')
    try: es_admin = ctypes.windll.shell32.IsUserAnAdmin()
    except: es_admin = False
    
    if not es_admin: print("\n[!] ADVERTENCIA: EJECUTA COMO ADMINISTRADOR [!]\n")

    ancho, alto = pyautogui.size()
    cx, cy = ancho // 2, alto // 2

    print(f"=== VERSIÓN 21 (SNIPER MODE / PRECISIÓN) ===")
    print(f"Resolución: {ancho}x{alto}")
    print("Comandos: on, test, monitor, magenta, c, salir")
    print("TECLA MAESTRA: 'Ñ' para activar/desactivar en partida.")

    hilo_teclas = threading.Thread(target=tarea_hotkeys)
    hilo_teclas.daemon = True
    hilo_teclas.start()

    hilo_escaneo = threading.Thread(target=tarea_escanear, args=(cx, cy))
    hilo_escaneo.daemon = True
    hilo_escaneo.start()

    while True:
        try:
            cmd = input(f">> ").strip().lower()
            
            if cmd == "salir":
                PROGRAMA_ACTIVO = False
                EJECUTANDO = False
                break
            elif cmd == "test":
                prueba_input()
            elif cmd == "monitor":
                monitor_mouse()
            elif cmd == "dibujar":
                dibujar_guia(cx, cy)
            elif cmd == "magenta":
                OBJETIVO_COLOR = (255, 0, 255)
                offset_actual = 0 
                TOLERANCIA = 60 # Un poco más relajado para pruebas sintéticas
                print("Modo Prueba Fucsia activado.")
            elif cmd == "c":
                print("Pon mouse en color (3s)...")
                time.sleep(3)
                px = pyautogui.position()
                OBJETIVO_COLOR = obtener_pixel_gdi(px[0], px[1])
                offset_actual = 0
                TOLERANCIA = 55 # Tolerancia ajustada a 55 para calibración manual
                print(f"Calibrado: {OBJETIVO_COLOR} (Tolerancia: {TOLERANCIA})")
            elif cmd == "on":
                EJECUTANDO = True
                print("ACTIVADO.")
            elif cmd == "off":
                EJECUTANDO = False
                print("PAUSADO.")
        except Exception as e: print(e)

if __name__ == "__main__":
    iniciar()