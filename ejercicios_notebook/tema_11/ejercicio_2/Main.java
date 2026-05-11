package ejercicios_notebook.tema_11.ejercicio_2;
/*
Entender la importancia del almacenamiento intermedio (buffering) para mejorar el rendimiento y el uso de Scanner para leer palabras sueltas.
Enunciado:
Crea un archivo de texto con varias líneas de palabras.
Utiliza un BufferedReader envolviendo a un FileReader para leer el archivo de forma eficiente.
Envuelve ese BufferedReader en un objeto Scanner.
Utiliza un bucle while(s.hasNext()) para imprimir cada palabra del archivo en una línea distinta de la consola
*/
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String filePath = "E:\\\\HugoAH\\\\Programacion\\\\ejercicios_notebook\\\\tema_11\\\\ejercicio_2\\\\palabras.txt";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filePath)))) {
            while (scanner.hasNext()) {
                String palabra = scanner.next();
                System.out.println(palabra);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
