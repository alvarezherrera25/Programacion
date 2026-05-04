package Programacion_3º_tri.Progtema_9.ejemplos_ordenar.trucos;

public class GestionDatos {
    public int[] v = { 25, 9, 3, 6, 2, 15, 4, 27, 42 };
    public double tiempoTotal; // <--- ESTE NOMBRE ES EL QUE BUSCA EL MAIN
    private double inicio;

    public void medir(boolean comenzar) {
        if (comenzar) {
            inicio = (double) System.nanoTime();
        } else {
            // Calculamos la diferencia y la pasamos a milisegundos
            tiempoTotal = (System.nanoTime() - inicio) / 1_000_000.0;
        }
    }
}