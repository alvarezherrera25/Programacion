package Ejercicios_Finales.segund_evaluacion.ejercicio_2;

/*
Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100 y que los
almacene en un vector. El programa debe ser capaz de pasar todos los números pares a las
primeras posiciones del vector (del 0 en adelante) y todos los números impares a las celdas
restantes. Nota: No es necesario que los números estén ordenados y puedes utiliza vectores
auxiliares, si es necesario.
*/
public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[20];
        int[] resultado = new int[20];
        int indiceRes = 0;

        for (int i = 0; i < 20; i++) {
            numeros[i] = (int) (Math.random() * 101);
        }

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                resultado[indiceRes] = numeros[i];
                indiceRes++;
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                resultado[indiceRes] = numeros[i];
                indiceRes++;
            }
        }

        System.out.println("Pares ordenados seguidos de impares ordenados:");
        for (int n : resultado) {
            System.out.print(n + " ");
        }
    }
}