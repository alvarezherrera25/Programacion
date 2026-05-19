package Ejercicios_Finales.tema_11.ejercicio_3;

import java.io.*;

public class ficheros {
    public void concatenar() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(
                "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_3\\Impares.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader(
                "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_3\\Pares.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_3\\Concatenado.txt"));
        String linea = br.readLine();
        String linea2 = br2.readLine();
        while (linea != null || linea2 != null) {
            if (linea != null) {
                bw.write(linea + "\n");
                linea = br.readLine();
            }
            if (linea2 != null) {
                bw.write(linea2 + "\n");
                linea2 = br2.readLine();
            }
        }
        br.close();
        br2.close();
        bw.close();
    }
}
