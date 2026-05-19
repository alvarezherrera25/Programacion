package Ejercicios_Finales.tema_11.ejercicio_4;

import java.io.*;
import java.util.*;

public class ficheros {
    public void ordenarPalabras() throws IOException {
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
    }
}
