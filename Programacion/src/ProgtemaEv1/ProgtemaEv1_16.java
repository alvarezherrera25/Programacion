package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_16 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);   


        System.out.print("Introduce el primer número (long): ");
        long num1 = sc.nextLong();
        System.out.print("Introduce el segundo número (long): ");
        long num2 = sc.nextLong();

        long pares = 0;
        long impares = 0;

        // La mezcla se hace de derecha a izquierda (último dígito de num1, último de num2, etc.)
        while (num1 > 0 || num2 > 0) {
            
            // A. Procesar dígito del PRIMER número
            long d1 = num1 % 10; // Extrae el último dígito
            num1 /= 10;          // Elimina el último dígito

            if (d1 % 2 == 0) {
                pares = pares * 10 + d1;
            } else {
                impares = impares * 10 + d1;
            }

            // B. Procesar dígito del SEGUNDO número
            long d2 = num2 % 10;
            num2 /= 10;

            if (d2 % 2 == 0) {
                pares = pares * 10 + d2;
            } else {
                impares = impares * 10 + d2;
            }
        }
        System.out.println("Resultado de dígitos PARES (NOTA: están al revés): " + pares);
        System.out.println("Resultado de dígitos IMPARES (NOTA: están al revés): " + impares);
    }
}
