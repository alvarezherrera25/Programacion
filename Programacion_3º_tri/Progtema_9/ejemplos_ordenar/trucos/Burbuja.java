package Programacion_3º_tri.Progtema_9.ejemplos_ordenar.trucos;

public class Burbuja extends Ordenar {
    @Override
    public void algoritmo(int[] v) { 
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
                // Para imprimir el proceso aquí, como no tienes acceso a GestionDatos,
                // puedes hacer un pequeño bucle para mostrar v:
                for(int n : v) System.out.print(n + " ");
                System.out.println();
            }
        }
    }
}