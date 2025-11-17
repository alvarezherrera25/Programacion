package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double euros;
        double pesetas;
        System.out.print("Introduce la cantidad en euros: ");
        euros = sc.nextDouble();
        pesetas = euros * 166.386;
        System.out.println(euros + " euros son " + pesetas + " pesetas."); 
    }
}
