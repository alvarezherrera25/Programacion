package Programacion_3º_tri.Progtema_9.ejemplos_ordenar.trucos;

public class QuickSort extends Ordenar {

    @Override
    public void algoritmo(int[] v) {
        System.out.println("--- Iniciando QuickSort ---");
        quicksort(v, 0, v.length - 1);
    }

    private void quicksort(int[] v, int izq, int der) {
        if (izq < der) {
            int indicePivote = particion(v, izq, der);
            
            // Imprimimos cómo va el array en cada división
            for (int n : v) System.out.print(n + " ");
            System.out.println();

            // Llamadas recursivas
            quicksort(v, izq, indicePivote - 1);
            quicksort(v, indicePivote + 1, der);
        }
    }

    private int particion(int[] v, int izq, int der) {
        int pivote = v[der]; // Elegimos el último como pivote
        int i = (izq - 1);

        for (int j = izq; j < der; j++) {
            if (v[j] <= pivote) {
                i++;
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
        }

        int temp = v[i + 1];
        v[i + 1] = v[der];
        v[der] = temp;

        return i + 1;
    }
}