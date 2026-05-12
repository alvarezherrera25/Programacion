package Ejercicios_Finales.segund_evaluacion.ejercicio_4;
/*
Un restaurante nos ha encargado una aplicación para colocar a los clientes en sus mesas. En
una mesa se pueden sentar de 0 (mesa vacía) a 4 comensales (mesa llena).
Cuando llega un cliente se le pregunta cuántos son. De momento el programa no está
preparado para colocar a grupos mayores a 4, por tanto, si un cliente dice por ejemplo que
son un grupo de 6, el programa dará el mensaje “Lo siento, no admitimos grupos de 6, solo
grupos de 4 personas como máximo”. Para el grupo que llega, se busca siempre la primera
mesa libre (con 0 personas). Si no quedan mesas libres, se indica con el mensaje “Lo siento,
no quedan mesas libres”. Una mesa puede quedar libre porque sus comensales han
finalizado.
Escribe un programa interactivo en el que puedas ir ocupando/liberando 10 mesas (de la 1
a la 10), hasta que decidas finalizar. El programa debe mostrar el estado de las mesas cada
vez que éste cambia.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mesas = new int[10]; 
        boolean finalizar = false;

        while (!finalizar) {
            System.out.println("¿Cuantos son?");
            int comensales = sc.nextInt();
            if (comensales > 4) {
                System.out.println("Lo siento, no admitimos grupos de " + comensales + ", solo grupos de 4 personas como máximo");
            } else {
                boolean mesaEncontrada = false;
                for (int i = 0; i < mesas.length; i++) {
                    if (mesas[i] == 0) {
                        mesas[i] = comensales;
                        mesaEncontrada = true;
                        System.out.println("Mesa " + (i + 1) + " ocupada por " + comensales + " comensales.");
                        break;
                    }
                }
                if (!mesaEncontrada) {
                    System.out.println("Lo siento, no quedan mesas libres.");
                }
            }
            System.out.println("¿Desea finalizar? (s/n)");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("s")) {
                finalizar = true;
            }
        }
        System.out.println("Estado final de las mesas:");
        for (int i = 0; i < mesas.length; i++) {
            System.out.println("Mesa " + (i + 1) + ": " + mesas[i] + " comensales.");
        } 
    }
}