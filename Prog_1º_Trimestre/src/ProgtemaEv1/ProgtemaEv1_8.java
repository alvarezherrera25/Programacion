package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double g = 9.81;
        double h;
        double t;
        System.out.print("Introduce altura: ");
        h = sc.nextDouble();
        t = Math.sqrt(2*h / g);
        System.out.printf("Tardara %.2f segundos", t);
    }
}
