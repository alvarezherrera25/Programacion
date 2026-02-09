import java.util.Scanner;

public class Progtema6_1 {
    public static void main (String[] args) {
        int[] numero =  new int [20];
        int suma = 0;

        for (int i = 0; i < 20; i++) {
            numero[i] = (int)(Math.random() * 100);
            suma += numero[i];
        }
        double media = (double) suma / 20;
        System.out.println("Por encima de la media");
        for (int i = 0 ; i < 20; i++){
            if (numero[i] > media){
            System.out.println(numero[i]); 
            }
        }
        System.out.println("Por debajo de la media");
        for (int i = 0 ; i < 20; i++){
            if (numero[i] < media){
            System.out.println(numero[i]); 
            }
        }
        System.out.println("Igual a la media");
        for (int i = 0 ; i < 20; i++){
            if (numero[i] == media){
            System.out.println(numero[i]); 
            }
        }
    }
}
