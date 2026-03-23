package Programacion_3º_tri.Progtema_9.ejemplos_ordenar;

public class PruebaRendimientoSeleccion {

    public static void main(String[] args) {
        int tamaño = 20000; 
        int[] vectorOriginal = new int[tamaño];

        for (int i = 0; i < vectorOriginal.length; i++) {
            vectorOriginal[i] = (int) (Math.random() * 1000000000);
        }

        long tiempoTotal = 0;
        int[] v = new int[vectorOriginal.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = vectorOriginal[i];
        }

        System.out.println("Ordenando " + tamaño + " elementos.");

        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < v.length - 1; i++) {
            int posMin = i;

            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[posMin]) {
                    posMin = j;
                }
            }

            int aux = v[posMin];
            v[posMin] = v[i];
            v[i] = aux;
        }

        tiempoTotal = System.currentTimeMillis() - tiempoInicio;

        System.out.println("Tiempo empleado: " + tiempoTotal + " milisegundos.");
    }
}
