package ejercicios_notebook.tema_11.ejercicio_1;
/*
Practicar el uso de FileReader y FileWriter para manipular archivos de texto plano.
Enunciado:
Crea un programa que lea un archivo de texto llamado original.txt carácter a carácter.
El programa debe escribir el contenido en un nuevo archivo llamado copia.txt.
Utiliza la estructura try-finally para asegurar que ambos flujos se cierren correctamente al terminar, incluso si ocurre un error.
Pista: Recuerda que el método read() devuelve -1 cuando llega al final del fichero
*/
import java.io.*;
public class Main {
    public static void main(String[] args) {
        String originalFile = "C:\\Users\\alvarezherrera\\Documents\\Programacion\\ejercicios_notebook\\tema_11\\ejercicio_1\\original.txt";
        String copyFile = "C:\\Users\\alvarezherrera\\Documents\\Programacion\\ejercicios_notebook\\tema_11\\ejercicio_1\\copia.txt";
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(originalFile);
            writer = new FileWriter(copyFile);
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("Archivo copiado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al manipular los archivos: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar los archivos: " + e.getMessage());
            }
        }
    }
}
