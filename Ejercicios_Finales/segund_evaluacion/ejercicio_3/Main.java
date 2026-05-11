package Ejercicios_Finales.segund_evaluacion.ejercicio_3;

/*
Escribe un programa que rellene un vector de 100 elementos con números enteros
aleatorios comprendidos entre 100 y 500 (ambos incluidos). A continuación, el programa
mostrará el mínimo y el máximo de los cien.
*/
public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[100];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 401) + 100;
        }

        int maximo = numeros[0];
        int minimo = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
            if (numeros[i] < minimo) {
                minimo = numeros[i];
            }
        }
        System.out.println("El numero maximo es: " + maximo);
        System.out.println("El numero minimo es: " + minimo);
    }
}
