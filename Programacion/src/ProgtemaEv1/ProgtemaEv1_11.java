package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_11 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        double PRECIO_NORMAL = 8.0;
        double PRECIO_MIERCOLES = 5.0;
        double PRECIO_PAREJA_JUEVES = 11.0;
        double DESCUENTO_CINEPAS = 0.90; // 10%
        double precioTotal = 0.0;

        System.out.print("Ingresa el día de la semana (Lunes, Miércoles, Jueves, etc.): ");
        String dia = sc.nextLine();

        System.out.print("¿Tienes tarjeta CinePas?");
        String tarjeta = sc.nextLine();

        System.out.print("Ingresa cuántas personas son: ");
        int N_personas = sc.nextInt();

        if (dia.equalsIgnoreCase("miercoles")){
            precioTotal = PRECIO_MIERCOLES * N_personas;

        } else if (dia.equalsIgnoreCase("jueves")){

            int N_parejas = N_personas / 2;
            int N_individuales = N_personas % 2;
            precioTotal = (N_parejas * PRECIO_PAREJA_JUEVES) + (N_individuales * PRECIO_NORMAL);

        } else if (dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("viernes") || dia.equalsIgnoreCase("sabado") || dia.equalsIgnoreCase("domingo")){
            precioTotal = N_personas * PRECIO_NORMAL;
        } else {
            System.out.println("Dia de la semana no reconocido");
        }

        if (tarjeta.equalsIgnoreCase("si")) {
            precioTotal = precioTotal * DESCUENTO_CINEPAS;
        }
        System.out.println("  - Día: " + dia);
        System.out.println("  - Personas: " + N_personas);
        System.out.println("  - TOTAL A PAGAR: " + String.format("%.2f", precioTotal) + " euros");
    }
}
