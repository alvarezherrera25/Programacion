import cv2
import numpy as np
import mss
import time
import random
import ctypes
import os
import math
import torch
import torch.nn as nn
import torch.optim as optim
import threading

# -----------------------------------------------------------------------------
# CONFIGURACIÓN DEL SISTEMA Y MOUSE
# -----------------------------------------------------------------------------
try:
    ctypes.windll.shcore.SetProcessDpiAwareness(2)
except:
    pass

user32 = ctypes.windll.user32
screen_width = user32.GetSystemMetrics(0)
screen_height = user32.GetSystemMetrics(1)
CENTER_X = screen_width // 2
CENTER_Y = screen_height // 2

# Estructuras para SendInput (Input Lag bajo)
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

def move_mouse(dx, dy):
    extra = ctypes.c_ulong(0)
    ii = Input_I()
    ii.mi = MouseInput(int(dx), int(dy), 0, 0x0001, 0, ctypes.pointer(extra))
    x = Input(ctypes.c_ulong(0), ii)
    user32.SendInput(1, ctypes.pointer(x), ctypes.sizeof(x))

def click_mouse():
    extra = ctypes.c_ulong(0)
    ii_down = Input_I()
    ii_down.mi = MouseInput(0, 0, 0, 0x0002, 0, ctypes.pointer(extra))
    x_down = Input(ctypes.c_ulong(0), ii_down)
    user32.SendInput(1, ctypes.pointer(x_down), ctypes.sizeof(x_down))
    
    # Muy breve espera
    time.sleep(0.01)
    
    ii_up = Input_I()
    ii_up.mi = MouseInput(0, 0, 0, 0x0004, 0, ctypes.pointer(extra))
    x_up = Input(ctypes.c_ulong(0), ii_up)
    user32.SendInput(1, ctypes.pointer(x_up), ctypes.sizeof(x_up))

# -----------------------------------------------------------------------------
# CEREBRO DE LA IA (DQN - Deep Q-Network)
# -----------------------------------------------------------------------------
# Input: [dist_x, dist_y] (Normalizado)
# Output: 5 Acciones [Quieto, Arriba, Abajo, Izquierda, Derecha]
#         * Nota: El disparo se gestionará si la confianza de "Quieto" es alta y distancia baja.

class Brain(nn.Module):
    def __init__(self):
        super(Brain, self).__init__()
        self.fc1 = nn.Linear(2, 64)  # Entrada: dx, dy
        self.fc2 = nn.Linear(64, 64)
        self.fc3 = nn.Linear(64, 5)  # Salida: 5 acciones discreta
        
    def forward(self, x):
        x = torch.relu(self.fc1(x))
        x = torch.relu(self.fc2(x))
        return self.fc3(x)

# -----------------------------------------------------------------------------
# AGENTE DE APRENDIZAJE
# -----------------------------------------------------------------------------
class AimAgent:
    def __init__(self):
        self.device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        print(f"[IA] Usando dispositivo: {self.device}")
        
        self.model = Brain().to(self.device)
        self.optimizer = optim.Adam(self.model.parameters(), lr=0.001)
        self.criterion = nn.MSELoss()
        
        self.gamma = 0.90      # Descuento a futuro (valora recompensas rápidas)
        self.epsilon = 1.0     # Exploración inicial (100% aleatorio)
        self.epsilon_min = 0.05
        self.epsilon_decay = 0.995
        
        self.memory = []
        self.batch_size = 64
        self.memory_capacity = 10000
        
        # Estado previo
        self.prev_state = None
        self.prev_action = None
        self.prev_dist = 0
        
    def get_action(self, state_tensor):
        # Epsilon-greedy: Explorar o Explotar
        if random.random() < self.epsilon:
            return random.randint(0, 4) # 0:Wait, 1:Up, 2:Down, 3:Left, 4:Right
        
        with torch.no_grad():
            q_values = self.model(state_tensor)
            return torch.argmax(q_values).item()

    def remember(self, state, action, reward, next_state, done):
        self.memory.append((state, action, reward, next_state, done))
        if len(self.memory) > self.memory_capacity:
            self.memory.pop(0)

    def train_step(self):
        if len(self.memory) < self.batch_size:
            return
        
        batch = random.sample(self.memory, self.batch_size)
        
        states = torch.cat([x[0] for x in batch])
        actions = torch.tensor([x[1] for x in batch], device=self.device)
        rewards = torch.tensor([x[2] for x in batch], device=self.device)
        next_states = torch.cat([x[3] for x in batch])
        dones = torch.tensor([x[4] for x in batch], device=self.device, dtype=torch.float)
        
        # Q(s,a) actual
        current_q = self.model(states).gather(1, actions.unsqueeze(1)).squeeze(1)
        
        # Max Q(s', a')
        next_q = self.model(next_states).max(1)[0]
        
        # Target Q = Reward + Gamma * Max Q(s') (si no terminó el episodio)
        target_q = rewards + (self.gamma * next_q * (1 - dones))
        
        loss = self.criterion(current_q, target_q.detach())
        
        self.optimizer.zero_grad()
        loss.backward()
        self.optimizer.step()
        
        # Decaer exploración
        if self.epsilon > self.epsilon_min:
            self.epsilon *= self.epsilon_decay

# -----------------------------------------------------------------------------
# DETECTOR VISUAL (Reutilizado de auto_trigger.py)
# -----------------------------------------------------------------------------
class VisualEnv:
    def __init__(self):
        self.sct = mss.mss()
        self.fov = 300 # Zona de visión cuadrática
        self.monitor = {
            "top": CENTER_Y - (self.fov // 2),
            "left": CENTER_X - (self.fov // 2),
            "width": self.fov,
            "height": self.fov
        }
    
    def get_state(self):
        """Captura pantalla y retorna vector de estado: [norm_dx, norm_dy] y si hay target."""
        screenshot = self.sct.grab(self.monitor)
        img = np.array(screenshot)
        img = img[:, :, :3] # BGRA -> BGR
        
        # Detectar color AZUL / NARANJA (Target Aim Trainer)
        hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
        
        # Rangos combinados aproximados
        mask_blue = cv2.inRange(hsv, np.array([90, 100, 50]), np.array([135, 255, 255]))
        mask_orange = cv2.inRange(hsv, np.array([10, 100, 100]), np.array([25, 255, 255]))
        mask = mask_blue | mask_orange
        
        contours, _ = cv2.findContours(mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
        
        mid = self.fov // 2
        
        closest_target = None
        min_dist = 9999
        
        for cnt in contours:
            area = cv2.contourArea(cnt)
            if area < 50: continue # Ruido
            
            x, y, w, h = cv2.boundingRect(cnt)
            cx = x + w // 2
            cy = y + h // 2
            
            dist = math.hypot(cx - mid, cy - mid)
            if dist < min_dist:
                min_dist = dist
                closest_target = (cx - mid, cy - mid) # Relativo al centro
                
        if closest_target:
            dx, dy = closest_target
            # Normalizar entre -1 y 1
            state = [dx / (self.fov/2), dy / (self.fov/2)]
            return state, img, (dx, dy)
        else:
            return None, img, None

# -----------------------------------------------------------------------------
# BUCLE PRINCIPAL DE ENTRENAMIENTO
# -----------------------------------------------------------------------------
def run_training():
    env = VisualEnv()
    agent = AimAgent()
    
    print("--- INICIANDO ENTRENAMIENTO DE IA ---")
    print("Mueve la ventana del juego al centro.")
    print("Presiona Ctrl+C en la consola para parar.")
    time.sleep(3)
    
    frame_count = 0
    scores = []
    
    while True:
        # 1. Observar Estado
        state_data, img, raw_pos = env.get_state()
        
        if state_data is None:
            # No hay target, giramos un poco para buscar o esperamos
            # Penalización leve por no encontrar target
            pass
            cv2.imshow("IA VISION (Learning)", img)
            if cv2.waitKey(1) & 0xFF == ord('q'): break
            continue
            
        state_tensor = torch.FloatTensor([state_data]).to(agent.device)
        
        # 2. Decidir Acción
        action = agent.get_action(state_tensor)
        
        # 3. Ejecutar Acción
        # Mapeo de acciones: 0:Nada, 1:Up, 2:Down, 3:Left, 4:Right
        MOVE_SPEED = 15 # Pixeles
        dx, dy = 0, 0
        
        if action == 1: dy = -MOVE_SPEED
        elif action == 2: dy = MOVE_SPEED
        elif action == 3: dx = -MOVE_SPEED
        elif action == 4: dx = MOVE_SPEED
        
        if dx != 0 or dy != 0:
            move_mouse(dx, dy)
        
        # Simular disparo si estamos muy cerca
        current_dist = math.hypot(raw_pos[0], raw_pos[1])
        SHOOT_THRESHOLD = 20 # Pixeles
        triggered = False
        
        if current_dist < SHOOT_THRESHOLD and action == 0: # Acción 0 es 'Stabilize/Wait'
            click_mouse()
            triggered = True
            print("¡DISPARO!")
        
        # 4. Calcular Recompensa
        # Capturamos nuevo estado inmediatamente después del movimiento
        next_state_data, next_img, next_raw_pos = env.get_state()
        
        reward = 0
        done = False
        
        if next_state_data is None:
            # Target desapareció (¿Matamos al target?)
            if triggered:
                reward = 10.0 # GRAN RECOMPENSA: Target eliminado
                print(f"RECOMPENSA: KILL (+10) | Epsilon: {agent.epsilon:.2f}")
                done = True # Fin de este "micro-episodio" de target
            else:
                reward = -0.1 # Target perdido sin disparar
        else:
            # Calcular mejora en distancia
            next_dist = math.hypot(next_raw_pos[0], next_raw_pos[1])
            dist_improvement = current_dist - next_dist # Si es positivo, nos acercamos
            
            reward = dist_improvement * 0.1 # Recompensa proporcional al acercamiento
            
            # Penalización por tiempo/distancia
            reward -= 0.01 
            
            # Penalización por disparar al aire
            if triggered and next_dist > SHOOT_THRESHOLD:
                reward = -2.0 
        
        # 5. Entrenar (Replay Buffer)
        if next_state_data is not None:
             next_state_tensor = torch.FloatTensor([next_state_data]).to(agent.device)
        else:
             # Estado terminal ficticio (todo ceros)
             next_state_tensor = torch.zeros((1, 2)).to(agent.device)
             
        agent.remember(state_tensor, action, reward, next_state_tensor, done)
        agent.train_step()
        
        # Visualización
        if next_raw_pos:
            cx = (env.fov // 2) + int(next_raw_pos[0])
            cy = (env.fov // 2) + int(next_raw_pos[1])
            cv2.line(next_img, (env.fov//2, env.fov//2), (cx, cy), (0, 255, 0), 1)
        
        cv2.imshow("IA VISION (Learning)", next_img if next_img is not None else img)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

if __name__ == "__main__":
    run_training()
