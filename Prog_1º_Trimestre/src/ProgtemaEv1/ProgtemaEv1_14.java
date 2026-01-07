package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_14 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Carácter de relleno: ");
    String c = sc.nextLine();
    int altura;

    do {
        System.out.print("Altura (mínimo 2): ");
        altura = sc.nextInt();
    } while (altura < 2);

    int direccion;
    do {
            System.out.println("1. Arriba | 2. Abajo | 3. Izquierda | 4. Derecha");
            System.out.print("Elige la dirección (1-4): ");
            direccion = sc.nextInt();
    } while (direccion < 1 || direccion > 4);

    System.out.println("Piramide");

        if (direccion == 1) {
            for (int i = 0; i < altura; i++) {
                // Espacios
                for (int j = 0; j < altura - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        } else if (direccion == 2) { 
            for (int i = altura - 1; i >= 0; i--) {
                // Espacios
                for (int j = 0; j < altura - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        } else if (direccion == 3) {
           // Parte superior
            for (int i = 0; i < altura; i++) {
                // Caracteres
                for (int j = 0; j <= i; j++) {
                    System.out.print(c);
                }
                System.out.println();
                // Parte inferior
            } for (int i = altura - 2; i >= 0; i--) {
                // Caracteres
                for (int j = 0; j <= i; j++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        } else if (direccion == 4) {
            // Parte superior
            for (int i = 0; i < altura; i++) {
                // Espacios
                for (int j = 0; j < altura - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k <= i; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
            // Parte inferior
            for (int i = altura - 2; i >= 0; i--) {
                // Espacios
                for (int j = 0; j < altura - i - 1; j++) {
                    System.out.print(" ");
                }
                // Caracteres
                for (int k = 0; k <= i; k++) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}

