package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_20 {
    public static void main(String[] args) {
    
        int i1 = (int)(Math.random() * 5);
        int i2 = (int)(Math.random() * 5);
        int i3 = (int)(Math.random() * 5);

        String f1, f2, f3;

   
        if (i1 == 0) f1 = "CORAZON";
        else if (i1 == 1) f1 = "DIAMANTE";
        else if (i1 == 2) f1 = "HERRADURA";
        else if (i1 == 3) f1 = "CAMPANA";
        else f1 = "LIMON";
        

        if (i2 == 0) f2 = "CORAZON";
        else if (i2 == 1) f2 = "DIAMANTE";
        else if (i2 == 2) f2 = "HERRADURA";
        else if (i2 == 3) f2 = "CAMPANA";
        else f2 = "LIMON";


        if (i3 == 0) f3 = "CORAZON";
        else if (i3 == 1) f3 = "DIAMANTE";
        else if (i3 == 2) f3 = "HERRADURA";
        else if (i3 == 3) f3 = "CAMPANA";
        else f3 = "LIMON";


        System.out.println("--- ¡TIRADA DE LA PALANCA! ---");
        System.out.println("Resultado: [" + f1 + "] | [" + f2 + "] | [" + f3 + "]");



        if (f1.equals(f2) && f2.equals(f3)) {
            System.out.println("¡Enhorabuena, ha ganado 10 MONEDAS!");
        }  
        else if (!f1.equals(f2) && !f1.equals(f3) && !f2.equals(f3)) {
            System.out.println("Lo siento, ha perdido.");
        } 
        else {
            System.out.println("Bien, ha recuperado su MONEDAS.");
        }
    }
}