package Ejercicios_Finales.tema_11.ejercicio_6;

import java.io.*;

public class ficheros {
    public int contarOcurrencias(String palabra, String nombreFichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(
                "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_6\\palabras.txt"));
        int contador = 0;
        String linea = br.readLine();
        while (linea != null) {
            if (linea.equals(palabra)) {
                contador++;
            }
            linea = br.readLine();
        }
        br.close();
        return contador;
    }
}
