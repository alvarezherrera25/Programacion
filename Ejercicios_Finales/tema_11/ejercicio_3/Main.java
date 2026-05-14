package Ejercicios_Finales.tema_11.ejercicio_3;

/*
Escribe un programa que guarde en un fichero el contenido de otros dos ficheros,
de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos
ficheros mezcladas, es decir, la primera línea será del primer fichero, la segunda
será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
Los nombres de los dos ficheros origen y el nombre del fichero destino se deben
pasar como argumentos en la línea de comandos.
Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas
pueden tener tamaños diferentes.
*/
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_3\\Impares.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader(
                    "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_3\\Pares.txt"));
            String linea = br.readLine();
            String linea2 = br2.readLine();

            while (linea != null || linea2 != null) {
                if (linea != null) {
                    System.out.println(linea);
                    linea = br.readLine();
                }
                if (linea2 != null) {
                    System.out.println(linea2);
                    linea2 = br2.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
