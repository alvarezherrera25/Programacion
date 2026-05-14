package Ejercicios_Finales.tema_11.ejercicio_4;

/*
Realiza un programa que sea capaz de ordenar alfabéticamente las palabras
contenidas en un fichero de texto. El nombre del fichero que contiene las
palabras se debe pasar como argumento en la línea de comandos. El nombre
del fichero resultado debe ser el mismo que el original añadiendo la coletilla sort,
por ejemplo palabras_sort.txt. Suponemos que cada palabra ocupa una línea.
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_4\\nombres.txt"));
            ArrayList<String> nombres = new ArrayList<>();
            String linea = br.readLine();

            while (linea != null) {
                nombres.add(linea);
                linea = br.readLine();
            }
            Collections.sort(nombres);
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_4\\nombres_sort.txt"));
            for (String nombre : nombres) {
                bw.write(nombre + "\n");
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
