package Arrays;

// --- PARTE 2: El Programa Principal (Main) ---
public class Coche_Main {
    public static void main(String[] args) {
        Coche[] concesionario = new Coche[10];
        concesionario[0] = new Coche("Toyota", "Corolla", 12345);
        concesionario[1] = new Coche("Mazda", "3", 11111);
        // 3. Leemos un dato del primer coche
        System.out.println("La marca del primer coche es: " + concesionario[0].getMarca());

        // 4. Hacemos que el segundo coche realice una acción
        concesionario[0].arrancar();
        
        System.out.println("La macar del segundo coche es: " + concesionario[1].getMarca());
    }
}