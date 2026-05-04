package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número entero: ");
        String numero = sc.nextLine();
        
        System.out.print("Dígito a buscar: ");
        String digito = sc.nextLine();
        
        char Dbuscar = digito.charAt(0);

        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) == Dbuscar) {
                System.out.println("Posición(es): " + (i + 1));

            }
        }
    }
}