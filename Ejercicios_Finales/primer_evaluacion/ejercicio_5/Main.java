package Ejercicios_Finales.primer_evaluacion.ejercicio_5;

/*
Escribir un método que con dos parámetros enteros p y q nos devuelva el m.c.d.
(máximo común divisor) de ambos.
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer numero: ");
        int p = sc.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int q = sc.nextInt();

        System.out.println("El maximo comun divisor de " + p + " y " + q + " es: " + mcd(p, q));
    }

    public static int mcd(int p, int q) {
        for (int i = p; i >= 1; i--) {
            if (p % i == 0 && q % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
