package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_14_pista {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Carácter de relleno: ");
        String c = sc.nextLine();
        int h;
    
        do {
            System.out.print("Altura (mínimo 2): ");
            h = sc.nextInt();
        } while (h < 2);
        
        int d;
        do {
            System.out.println("1. Arriba | 2. Abajo | 3. Izquierda | 4. Derecha");
            System.out.print("Elige la dirección (1-4): ");
            d = sc.nextInt();
        } while (d < 1 || d > 4);

        System.out.println("Piramide");
        
        
        if (d == 1) { // Arriba
            for (int i = 0; i < h; i++) {
                // Espacios
                for (int j = 0; j < h - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        } else if (d == 2) { // Abajo
            for (int i = h - 1; i >= 0; i--) {
                // Espacios
                for (int j = 0; j < h - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        } else if (d == 3) { // Izquierda
            // Parte superior
            for (int i = 0; i < h; i++) {
                // Caracteres
                for (int j = 0; j <= i; j++) {
                    System.out.print(c);
                }
                System.out.println();
            }
            // Parte inferior
            for (int i = h - 2; i >= 0; i--) {
                // Caracteres
                for (int j = 0; j <= i; j++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        } else if (d == 4) { // Derecha
            // Parte superior
            for (int i = 0; i < h; i++) {
                // Espacios
                for (int j = 0; j < h - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k <= i; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
            // Parte inferior
            for (int i = h - 2; i >= 0; i--) {
                // Espacios
                for (int j = 0; j < h - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k <= i; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }

        sc.close();
    }
}