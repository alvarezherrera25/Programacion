package Ejercicios_Finales.tema_11.ejercicio_6;

/*
Realiza un programa que diga cuántas ocurrencias de una palabra hay en un
fichero. Tanto el nombre del fichero como la palabra se deben pasar como
argumentos en la línea de comandos.
*/
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ficheros f = new ficheros();
        try {
            int contador = f.contarOcurrencias("pepe", "palabras.txt");
            System.out.println("Palabra " + "pepe" + " encontrada " + contador + " veces");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
