package Ejercicios_Finales.tema_11.ejercicio_5;

import java.io.*;

/*
Escribe un programa capaz de quitar los comentarios de un programa de Java.
Se utilizaría de la siguiente manera:
quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO
Por ejemplo:
quita_comentarios hola.java holav2.java

crea un fichero con nombre holav2.java que contiene el código de hola.java pero
sin los comentarios.
*/
public class Main {
    public static void main(String[] args) {
        ficheros f = new ficheros();
        try {
            f.quitarComentarios();
            System.out.println("Comentarios eliminados. Fichero guardado en programa_sin_comentarios.java");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
