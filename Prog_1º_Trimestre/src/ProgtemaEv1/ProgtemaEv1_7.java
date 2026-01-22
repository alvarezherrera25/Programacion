package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_7 {
    public static void main(String[ ] args){
        Scanner sc = new Scanner(System.in);
        int h;
        int S = 12;
        int S_extra = 16;
        int h_limite = 40;
        int total;

        System.out.print("Introduce las horas trabajadas en la semana: ");
        h = sc.nextInt();

        if (h <= h_limite){
            total = h * S;
        }else {
            int h_normal = h_limite;
            int h_extra = h - h_limite;
            total = (h_normal * S) + (h_extra * S_extra);
        }
        System.out.println("El salario semanal es de: " + total + " euros.");
    }
}