package Ejercicios_Finales.tema_11.ejercicio_5;

import java.io.*;
import java.util.Scanner;

public class ficheros {
    public ficheros() {
    }

    public void quitarComentarios() throws IOException {
        BufferedInputStream var1 = new BufferedInputStream(new FileInputStream(
                "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_5\\programa.java"));
        BufferedOutputStream var2 = new BufferedOutputStream(new FileOutputStream(
                "C:\\Users\\alvarezherrera\\Documents\\Programacion\\Ejercicios_Finales\\tema_11\\ejercicio_5\\programa_sin_comentarios.java"));
        Scanner var3 = new Scanner(var1);
        PrintStream var4 = new PrintStream(var2);
        boolean var5 = false;

        while (var3.hasNextLine()) {
            String var6 = var3.nextLine().strip();
            if (var5) {
                if (var6.contains("*/")) {
                    var5 = false;
                }
            } else if (var6.startsWith("/*")) {
                var5 = true;
                if (var6.contains("*/")) {
                    var5 = false;
                }
            } else if (!var6.startsWith("//") && !var6.isEmpty()) {
                var4.println(var6);
            }
        }

        var4.flush();
        var3.close();
        var1.close();
        var2.close();
    }
}
