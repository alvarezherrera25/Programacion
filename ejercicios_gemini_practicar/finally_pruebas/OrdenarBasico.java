package ejercicios_gemini_practicar.finally_pruebas;

import java.util.Random;

public class OrdenarBasico {
    public static void main(String[] args) {
        int[] numeros = new int[1000000]; // Un millón de números
        Random rand = new Random();
        int errores = 0;

        System.out.println("--- Iniciando proceso de 1.000.000 de datos ---");

        for (int i = 0; i < numeros.length; i++) {
            try {
                // Generamos un fallo artificial para probar el catch
                // Si el número sale 500 (1 entre 1000), lanzamos error
                if (rand.nextInt(1000) == 500) {
                    throw new Exception("Fallo de lectura");
                }

                numeros[i] = rand.nextInt(10000); // Guardamos un número normal

            } catch (Exception e) {
                errores++;
                // No hay finally. El programa simplemente salta aquí y sigue.
            }
        }

        System.out.println("Proceso terminado.");
        System.out.println("Datos procesados: " + (numeros.length - errores));
        System.out.println("Datos perdidos por error: " + errores);
    }
}
