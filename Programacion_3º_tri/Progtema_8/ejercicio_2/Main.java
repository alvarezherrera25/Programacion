package Programacion_3º_tri.Progtema_8.ejercicio_2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int contador = 0;
        
        System.out.println("Introduce hasta 6 números (o un dato no válido para terminar).");

        while (contador < 6) {
            try {
                int numero = pedirEntero(sc);
                suma += numero;
                contador++;
            } catch (NumberFormatException e) {
                System.out.println("¡Dato no válido detectado! Finalizando la lectura...");

            }
        }

        System.out.println("La suma total de los números insertados es: " + suma);
        sc.close();
    }

    public static String pedirCadena(Scanner sc) {
        System.out.print("Introduce un número (" + "llevas " + "): ");
        return sc.nextLine();
    }

    public static int pedirEntero(Scanner sc) throws NumberFormatException {
        String texto = pedirCadena(sc);
        return Integer.parseInt(texto); 
    }
}

