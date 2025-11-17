package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_7 {
    public static void main(String[ ] args){
        Scanner sc = new Scanner(System.in);
        int horas;
        int salario;
        System.out.print("Introduce las horas trabajadas en la semana: ");
        horas = sc.nextInt();
        salario = horas * 12;
        System.out.println("El salario semanal es de: " + salario + " euros.");
    }
}
