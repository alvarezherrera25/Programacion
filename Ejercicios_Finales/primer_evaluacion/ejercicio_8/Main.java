package Ejercicios_Finales.primer_evaluacion.ejercicio_8;

/*
Dados m elementos de un conjunto que se desean agrupar de n en n, el número de
combinaciones posibles es m!/(n!*(m-n)!), siendo siempre m >=n (hay que validarlo)
Escribir un método para que, dados como parámetros m y n, nos calcule el número
de combinaciones de m sobre n.
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el numero m: ");
        int m = sc.nextInt();
        System.out.print("Introduce el numero n: ");
        int n = sc.nextInt();
        if (m >= n) {
            System.out.println("El numero de combinaciones es: " + (factorial(m) / (factorial(n) * factorial(m - n))));
        } else {
            System.out.println("El numero m debe ser mayor o igual que el numero n.");
        }
    }

    public static int factorial(int N) {
        int fact = 1;
        for (int i = 1; i <= N; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
