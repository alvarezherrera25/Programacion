package Ejercicios_Finales.tema_11.ejercicio_1y2;

/*
Escribe un programa que guarde en un fichero con nombre primos.txt los
números primos que hay entre 1 y 500. Buffered streams y sin try-with-resources (Busca en Wikipedia "Criba de
Eratóstenes)
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(
                            "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_1\\primos.txt"));
            for (int i = 1; i <= 500; i++) {
                if (esPrimo(i)) {
                    bw.write(i + "\n");
                }
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(
                            "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_1\\primos.txt"));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        } else {
            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}