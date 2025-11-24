package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_16 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);   

        System.out.print("Introduce el NÚMERO 1: ");
        long num1 = sc.nextLong();
        System.out.print("Introduce el NÚMERO 2 (misma longitud): ");
        long num2 = sc.nextLong();


        long mezclaInversa = 0; 


        while (num1 > 0) {
            
            long d1 = num1 % 10;
            num1 /= 10; 
            mezclaInversa = mezclaInversa * 10 + d1;


            long d2 = num2 % 10;
            num2 /= 10; 
            mezclaInversa = mezclaInversa * 10 + d2;
        }

        long resultadoMixto = 0;
        
        while (mezclaInversa != 0) {
            long digito = mezclaInversa % 10;
            resultadoMixto = resultadoMixto * 10 + digito;
            mezclaInversa /= 10;
        }

        System.out.println("El número mezclado final es: " + resultadoMixto);
    }
}