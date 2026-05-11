package Ejercicios_Finales.primer_evaluacion.ejercicio_9;

/*
Escribir un programa que llame a un método con los coeficientes de una ecuación de
segundo grado, a, b y c, y devuelva sus raíces en el caso de ser reales.
Nota. Las raíces de una ecuación son :
R1=(-b+raíz(b^2-4*a*c))/(2*a)
R2=(-b-raíz(b^2-4*a*c))/(2*a)

Para la raíz llamar a la clase Math y el método raíz que es sqrt.
Esta función solo se puede aplicar en el caso de que valor sea positivo es decir:
b^2-4*a*c > 0.
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el coeficiente a: ");
        int a = sc.nextInt();

        System.out.println("Introduce el coeficiente b: ");
        int b = sc.nextInt();

        System.out.println("Introduce el coeficiente c: ");
        int c = sc.nextInt();

        if (b * b - 4 * a * c >= 0) {
            System.out.println("Las raices son: ");
            double r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            System.out.println("r1: " + r1);
            System.out.println("r2: " + r2);
        } else {
            System.out.println("La ecuacion no tiene raices reales.");
        }
    }
}