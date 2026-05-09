package ejercicios_notebook.tema_8.ejercicio_4;
/*
Escribe un método que lea un número de un vector de enteros en una posición dada por el usuario.
El código debe ser capaz de capturar en bloques catch diferentes:
InputMismatchException (si el usuario introduce una letra en lugar de un número).
ArrayIndexOutOfBoundsException (si el usuario pide una posición que no existe en el vector).
Utiliza la captura múltiple en un solo bloque usando la barra vertical (|) si prefieres dar el mismo tratamiento a ambos errores

 */
import java.util.*;
public class Main {
    public static void main (String[] args) {
        int[] vector = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la posición del vector que quieres leer: ");

        try {
            int posicion = sc.nextInt() - 1;
            int valor = vector[posicion];
            System.out.println("El valor en la posición " + (posicion + 1) + " es: " + valor);
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
