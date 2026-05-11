package Ejercicios_Finales.primer_evaluacion.ejercicio_3;

/*
Se define el factorial de un número N como N*(N-1)*(N-2)*.......*3*2*1. Hacer un
programa que lea un número N filtrando a que sea mayor que cero y calcule su
factorial
La función a construir aquí se llamará factorial. El método main solo debe leer
un valor y devolver su factorial (versión iterativa).
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        int N = sc.nextInt();

        System.out.println("El factorial de " + N + " es: " + factorial(N));
    }

    public static int factorial(int N) {
        int fact = 1;
        for (int i = 1; i <= N; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
