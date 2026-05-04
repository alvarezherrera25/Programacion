package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_16 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);   

        System.out.print("Introduce el NÚMERO 1: ");
        long num1 = sc.nextLong();
        System.out.print("Introduce el NÚMERO 2 (misma longitud): ");
        long num2 = sc.nextLong();

        // Variables de construcción (almacenan el resultado INVERSO)
        long tempPares = 0;
        long tempImpares = 0;
        long factor = 1; 

        // Variables de trabajo (copias)
        long t1 = num1;
        long t2 = num2;
        
        // --- 2. Lógica de Mezcla y Separación ---
        while (t1 > 0 || t2 > 0) {
            
            // A. Procesar n1 (si aún tiene dígitos)
            if (t1 > 0) {
                int digito1 = (int) (t1 % 10);
                if (digito1 % 2 == 0) {
                    tempPares += digito1 * factor;
                } else {
                    tempImpares += digito1 * factor;
                }
                t1 /= 10;
            }

            // B. Procesar n2 (si aún tiene dígitos)
            if (t2 > 0) {
                int digito2 = (int) (t2 % 10);
                if (digito2 % 2 == 0) {
                    tempPares += digito2 * factor;
                } else {
                    tempImpares += digito2 * factor;
                }
                t2 /= 10;
            }
            
            factor *= 10; 
        }
        

        System.out.println("Dígitos pares: " + tempPares);
        System.out.println("Dígitos impares: " + tempImpares);
    }
}