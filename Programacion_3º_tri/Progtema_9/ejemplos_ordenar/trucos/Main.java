package Programacion_3º_tri.Progtema_9.ejemplos_ordenar.trucos;

public class Main {
    public static void main(String[] args) {
        GestionDatos g = new GestionDatos();
        
        // Añades algoritmos
        Ordenar[] misAlgoritmos = new Ordenar[3];
        misAlgoritmos[0] = new Burbuja();
        misAlgoritmos[1] = new ShellSort();
        misAlgoritmos[2] = new QuickSort(); // El nuevo hijo

        for (int i = 0; i < misAlgoritmos.length; i++) {
            
            g.v = new int[]{25, 9, 3, 6, 2, 15, 4, 27, 42, 800};

            System.out.println("\n************************************");
            System.out.println("PROBANDO MÉTODO: " + misAlgoritmos[i].getClass().getSimpleName());
            
            g.medir(true);
            misAlgoritmos[i].algoritmo(g.v);
            g.medir(false);
            
            System.out.println("------------------------------------");
            System.out.println("Tiempo de ejecución: " + g.tiempoTotal + " ms");
            System.out.println("************************************\n");
        }
    }
}