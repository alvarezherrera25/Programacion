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
        ficheros f = new ficheros();
        try {
            f.ordenarPalabras();
            System.out.println("Fichero ordenado correctamente");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
