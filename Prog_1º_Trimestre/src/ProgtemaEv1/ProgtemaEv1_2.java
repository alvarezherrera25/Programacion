package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double Rsuma = 0;
        double Rresta = 0;
        double Rmulti = 0;
        double Rdivi = 0;
        double num1;
        double num2;
        System.out.print("Introduce el primer numero: ");
        num1 = sc.nextDouble();
        System.out.print("Introduce el segundo numero: ");
        num2 = sc.nextDouble();
        Rsuma = num1 + num2;
        Rresta = num1 - num2;
        Rmulti = num1 * num2;
        Rdivi = num1 / num2;
        System.out.println("La suma es: " + Rsuma);
        System.out.println("La resta es: " + Rresta);
        System.out.println("La multiplicacion es: " + Rmulti);
        System.out.println("La division es: " + Rdivi);
    }   
}
