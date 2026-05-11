package Ejercicios_Finales.primer_evaluacion.ejercicio_2;
/*
Dados dos números P y Q que leeremos por teclado y que deben ser positivos, hacer
un programa que nos diga cuál de los dos tiene más divisores, con un mensaje que
diga “P tiene más divisores que Q” o viceversa.
Este programa debe llamar a un método que calcule los divisores de un número,
lo aplique para P y para Q y luego compare y decida.
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero entero:");
        int P = sc.nextInt();
        System.out.println("Introduce otro numero entero:");
        int Q = sc.nextInt();

        if (calcularDivisores(P) > calcularDivisores(Q)) {
            System.out.println(P + " tiene mas divisores que " + Q);
        } else {
            System.out.println(Q + " tiene mas divisores que " + P);
        }
    }
    public static int calcularDivisores(int num){
        int divisores = 0;
        for (int i = 1; i <= num; i++){
            if (num % i == 0){
                divisores++;
            }
        }
        return divisores;
    }
}
