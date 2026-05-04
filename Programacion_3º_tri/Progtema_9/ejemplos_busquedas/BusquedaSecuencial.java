package Programacion_3º_tri.Progtema_9.ejemplos_busquedas;

public class BusquedaSecuencial {
    public static void main(String[] args) {
        int[] numeros = {12, 45, 7, 23, 56, 89, 10, 3};
        int objetivo = 23;

        int i = 0;
        boolean encontrado = false;


        while (i < numeros.length && !encontrado) {
            if (numeros[i] == objetivo) {
                encontrado = true; 
            } else {
                i++; 
            }
        }

        if (encontrado) {
            System.out.println("Número encontrado en la posición: " + i);
        } else {
            System.out.println("El número no está en la lista.");
        }
    }
}