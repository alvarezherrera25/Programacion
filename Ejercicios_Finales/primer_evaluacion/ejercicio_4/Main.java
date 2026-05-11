package Ejercicios_Finales.primer_evaluacion.ejercicio_4;

/*
Dado un número N que se pedirá por teclado y debe ser positivo, imprimir la lista de
todos los numero primos hasta dicho número incluido.
Hacer este programa usando el método primo que ya tenéis construido.
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            if (primo(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean primo(int numero) {
        if (numero <= 1) {
            return false;
        } else {
            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
