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

    System.out.println("Piramide");
    

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

    }
}
