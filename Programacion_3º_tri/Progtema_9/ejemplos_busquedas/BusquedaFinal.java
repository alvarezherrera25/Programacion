package Programacion_3º_tri.Progtema_9.ejemplos_busquedas;

public class BusquedaFinal {
    public static void main(String[] args) {
        int[] v = {3, 7, 10, 15, 20}; 
        int x = 8;
        int i = 0;


        while (i < v.length && v[i] < x) {
            System.out.println("Revisando " + v[i] + "...");
            i++;
        }

        if (i < v.length && v[i] == x) {
            System.out.println("Encontrado en el índice: " + i);
        } else {
            System.out.println("Búsqueda finalizada: El número no está.");
            if (i < v.length) {
                System.out.println("Se detuvo en el " + v[i] + " porque ya es mayor que " + x);
            }
        }
    }
}

