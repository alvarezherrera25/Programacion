#include <Mouse.h>

void setup() {
  Serial.begin(115200);
  Serial.setTimeout(1); // Lectura rápida
  Mouse.begin();
}

void loop() {
  if (Serial.available() > 0) {
    String data = Serial.readStringUntil('\n');
    
    // Comando MOVIMIENTO: "Mx,y" (Ej: "M10,-5")
    if (data.startsWith("M")) {
      int commaIndex = data.indexOf(',');
      if (commaIndex != -1) {
        String xStr = data.substring(1, commaIndex);
        String yStr = data.substring(commaIndex + 1);
        
        int x = xStr.toInt();
        int y = yStr.toInt();
        
        // Mover mouse
        Mouse.move(x, y, 0);
      }
    }
    // Comando CLIC: "C"
    else if (data.startsWith("C")) {
      Mouse.click(MOUSE_LEFT);
    }
  }
}
