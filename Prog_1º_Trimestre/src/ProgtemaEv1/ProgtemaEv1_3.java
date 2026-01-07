package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double base = 0;
        double altura = 0;
        double area = 0;
        System.out.print("Introduce la base del rectangulo: ");
        base = sc.nextDouble();
        System.out.print("Introduce la altura del rectangulo: ");
        altura = sc.nextDouble();
        area = base * altura;
        System.out.print("El area del rectangulo es: " + area);
    }
}