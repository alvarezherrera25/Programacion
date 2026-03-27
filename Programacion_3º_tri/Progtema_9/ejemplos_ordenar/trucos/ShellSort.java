package Programacion_3º_tri.Progtema_9.ejemplos_ordenar.trucos;

public class ShellSort extends Ordenar {
    @Override
    public void algoritmo(int[] v) {
        // ShellSort
        for (int salto = v.length / 2; salto > 0; salto /= 2) {
            System.out.println("--- SALTO DE: " + salto + " ---");

            for (int i = salto; i < v.length; i++) {
                int aux = v[i];
                int j = i;

                while (j >= salto && v[j - salto] > aux) {
                    v[j] = v[j - salto];
                    j = j - salto;
                }
                v[j] = aux;

                // Imprimimos el estado del vector
                for (int k = 0; k < v.length; k++) {
                    System.out.print(v[k] + " ");
                }
                System.out.println(); 
            }
        }
    }
}