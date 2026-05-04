package Programacion_3º_tri.Progtema_9.ejemplos_ordenar;

public class EjemploBubbleLimpio {
    public static void main(String[] args) {
        int[] v = {25, 9, 3, 6, 2, 15, 4, 27, 42, 800};

        // --- ALGORITMO BUBBLE SORT ---
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                
                // Si el de la izquierda es mayor que el de la derecha...
                if (v[j] > v[j + 1]) {
                    
                    // ...los intercambiamos (usando tu lógica de aux)
                    int aux = v[j + 1];
                    v[j + 1] = v[j];
                    v[j] = aux;
                }
            }
        }

        // --- IMPRESIÓN DEL RESULTADO ---
        System.out.println("Lista ordenada con Burbuja:");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }
}