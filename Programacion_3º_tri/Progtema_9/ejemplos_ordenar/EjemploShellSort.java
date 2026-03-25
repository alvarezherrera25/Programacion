package Programacion_3º_tri.Progtema_9.ejemplos_ordenar;

public class EjemploShellSort {
    public static void main(String[] args) {
        int[] v = {25, 9, 3, 6, 2, 15, 4, 27, 42, 800};

        // 1. El SALTO empieza en 5 (n/2), luego bajará
        for (int salto = v.length / 2; salto > 0; salto /= 2) {
            System.out.println("--- USANDO SALTO DE: " + salto + " ---");

            for (int i = salto; i < v.length; i++) {
                int aux = v[i];
                int j = i;

                // Desplazamos los elementos
                while (j >= salto && v[j - salto] > aux) {
                    v[j] = v[j - salto];
                    j = j - salto;
                }
                
                // AQUÍ SE PONE EL NÚMERO EN SU SITIO
                v[j] = aux;

                // IMPRIMIMOS EL VECTOR YA CON EL CAMBIO HECHO
                for (int k = 0; k < v.length; k++) {
                    System.out.print(v[k] + " ");
                }
                System.out.println(); 
            }
        }
    }
}