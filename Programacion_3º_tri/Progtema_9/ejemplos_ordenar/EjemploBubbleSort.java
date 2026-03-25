package Programacion_3º_tri.Progtema_9.ejemplos_ordenar;

public class EjemploBubbleSort {
    public static void main(String[] args) {
        int[] v = {25, 9, 3, 6, 2, 15, 4, 27, 42, 800};
        int n = v.length;

        // BUCLE EXTERNO: Controla cuántas pasadas hacemos al mazo
        for (int i = 0; i < n - 1; i++) {
            
            // BUCLE INTERNO: Compara parejas de vecinos (j y j+1)
            // El "- i" es porque en cada pasada, el más grande ya "flotó" al final
            for (int j = 0; j < n - 1 - i; j++) {
                
                // Si el de la izquierda es mayor que el de la derecha...
                if (v[j] > v[j + 1]) {
                    
                    // ...los intercambiamos (usando tu lógica de aux)
                    int aux = v[j + 1];
                    v[j + 1] = v[j];
                    v[j] = aux;
                }
            }
        }
        System.out.println("Lista ordenada con Burbuja:");
        for (int i = 0; i < n; i++) {
            System.out.print(v[i] + " ");
        }
    }
}