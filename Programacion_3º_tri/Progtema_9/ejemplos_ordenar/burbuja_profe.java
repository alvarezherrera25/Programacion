package Programacion_3º_tri.Progtema_9.ejemplos_ordenar;

public class burbuja_profe {
    static int [] v = { 25, 9, 3, 6, 2, 15, 4, 27, 42};

    public static void main (String[] args) {
        // Capturamos el inicio
        long inicio = System.currentTimeMillis();

        // Algoritmo de Burbuja
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) { 
                if (v[j] > v[j+1]) {
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }

                for (int k = 0; k < v.length; k++) {
                    System.out.print(v[k] + " ");
                }
                System.out.println();
            }
        }

        // Capturamos el fin
        long fin = System.currentTimeMillis();

        // Convertimos a double para forzar los decimales
        double tiempoTotal = (double) fin - inicio;

        System.out.println("Tiempo de ejecución: " + tiempoTotal + " ms");
    }
}