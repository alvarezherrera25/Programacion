package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hora;
        System.out.println("¿Que hora es?");
        hora = sc.nextInt();

        if (hora >= 6 && hora <= 12) {
            System.out.print("Buenos dias");
        } else if (hora >= 13 && hora <= 20) {
            System.out.print("Buenas tardes"); 
        } else if (hora >= 21 && hora <= 24 || hora >= 0 && hora <= 5) {
            System.out.print("Buenas noches"); 
        } else {
            System.out.print("El dia tiene 24h (Introduce un valor entre 0 y 24)"); 
        }
    }
}
