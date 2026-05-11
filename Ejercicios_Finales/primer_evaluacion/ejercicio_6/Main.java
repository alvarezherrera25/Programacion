package Ejercicios_Finales.primer_evaluacion.ejercicio_6;

/*
Escribir un método que reciba dos parámetros enteros p y q y devuelva el mínimo
común múltiplo de ambos.
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer numero: ");
        int p = sc.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int q = sc.nextInt();

        System.out.println("El minimo multiplo comun de " + p + " y " + q + " es: " + mcm(p, q));
    }

    public static int mcm(int p, int q) {
        for (int i = 1; i <= p * q; i++) {
            if (i % p == 0 && i % q == 0) {
                return i;
            }
        }
        return 1;
    }
}
