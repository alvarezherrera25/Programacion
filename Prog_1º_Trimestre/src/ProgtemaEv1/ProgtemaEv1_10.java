package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("A que hora estás (0-23): ");
        int H = sc.nextInt();
        if (H < 0 || H >= 24) {
            System.out.print("Error: La hora debe estar entre 0 y 23.");
        }else {
            System.out.print("A qué minuto estás (0-59): ");
            int M = sc.nextInt();
            if (M < 0 || M >= 60) {
            System.out.println("Error: La hora debe estar entre 0 y 23.");
            }else {
                int SEGUNDOS_TOTALES_DIA = 24 * 3600; // 86400
                int segundosTranscurridos = (H * 3600) + (M * 60);
                int segundosRestantes = SEGUNDOS_TOTALES_DIA - segundosTranscurridos;
                System.out.println("Hora actual: " +  H + ":" + M);
                System.out.println("Faltan " + segundosRestantes + " segundos para el final del día.");

            }
        }
    }
}