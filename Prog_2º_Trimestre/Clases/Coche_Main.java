package Clases;

// --- PARTE 2: El Programa Principal (Main) ---
public class Coche_Main {
    public static void main(String[] args) {
        // 1. Construimos el primer objeto
        Coche miCoche = new Coche("Toyota", "Corolla", 12345);
        
        // 2. Construimos el segundo objeto
        Coche tuCoche = new Coche("Ford", "Focus", 98765);

        // 3. Leemos un dato del primer coche
        System.out.println("La marca del primer coche es: " + miCoche.getMarca());

        // 4. Hacemos que el segundo coche realice una acción
        tuCoche.arrancar();
    }
}