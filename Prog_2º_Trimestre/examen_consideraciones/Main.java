package Prog_2º_Trimestre.examen_consideraciones;
/* @Author
*  Hugo Álvarez Herrera
*  25/03/26
*  Explicación...
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Electrodomesticos[] lista = new Electrodomesticos[1000000];

        for (int i = 0; i < lista.length; i++) {
            int tipo = (int) (Math.random() * 3); 

            if (tipo == 0) {
                // Cafetera
                int modelo = (int) (Math.random() * 4) + 1;
                lista[i] = new Cafetera(modelo);
            } 
            else if (tipo == 1) {
                // Horno
                int modelo = (int) (Math.random() * 2) + 1;
                lista[i] = new Horno(modelo);
            } 
            else {
                // Frigorífico
                int modelo = (int) (Math.random() * 3) + 1;
                lista[i] = new Frigorifico(modelo);
            }

            if (Math.random() < 0.1) {
                int colorAleatorio = (int) (Math.random() * 16777216);
                lista[i].pintar(colorAleatorio);
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("Tipo: %s | Modelo: %d | Color: #%06X %n", 
                lista[i].getClass().getSimpleName(), 
                lista[i].getModelo(), 
                lista[i].getColor());
        }
    }
}