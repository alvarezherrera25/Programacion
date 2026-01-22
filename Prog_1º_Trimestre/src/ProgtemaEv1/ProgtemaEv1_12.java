package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String J1;
        String J2;

        System.out.print("Primer jugador (piedra/papel/tijera):");
        J1 = sc.nextLine();
        
        if (J1.equalsIgnoreCase("piedra")) {
            System.out.print("Segundo jugador (piedra/papel/tijera):");
            J2 = sc.nextLine();
            if (J2.equalsIgnoreCase("piedra")) {
                System.out.print("Empate");
            } else if (J2.equalsIgnoreCase("tijera")) {
                System.out.print("Gana jugador 1");
            } else if (J2.equalsIgnoreCase("papel")) {
                System.out.print("Gana jugador 2");
            } else {
                System.out.print("Opcion no reconocida");
            }
        } else if (J1.equalsIgnoreCase("papel")) {
            System.out.print("Segundo jugador (piedra/papel/tijera):");
            J2 = sc.nextLine();
            if (J2.equalsIgnoreCase("papel")) {
                System.out.print("Empate");
            } else if (J2.equalsIgnoreCase("piedra")) {
                System.out.print("Gana jugador 1");
            } else if (J2.equalsIgnoreCase("tijera")) {
                System.out.print("Gana jugador 2");
            } else {
                System.out.print("Opcion no reconocida");
            }
        } else if (J1.equalsIgnoreCase("tijera")) {
            System.out.print("Segundo jugador (piedra/papel/tijera):");
            J2 = sc.nextLine();
            if (J2.equalsIgnoreCase("tijera")) {
                System.out.print("Empate");
            } else if (J2.equalsIgnoreCase("papel")) {
                System.out.print("Gana jugador 1");
            } else if (J2.equalsIgnoreCase("piedra")) {
                System.out.print("Gana jugador 2");
            } else {
                System.out.print("Opcion no reconocida");
            }
        } else {
            System.out.print("Opcion no reconocida");
        }
    }
}