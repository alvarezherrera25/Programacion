package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double N1;
        double M;
        double N2;
        System.out.print("Introduce la nota del primer examen: ");
        N1 = sc.nextDouble();
        if (N1 > 10){
            System.out.print("Nota maxima es 10");
        } else{
            System.out.print("Que nota quieres sacar de media: ");
            M = sc.nextDouble();  

            if (M > 10){
               System.out.print("Nota maxima es 10"); 
            } else{
                N2 = M - (N1 * 0.3);
                N2 = N2 / 0.7;
                System.out.printf("Tienes que sacar en el segundo examen: %.2f%n", N2);
            }
        }
    }
}
