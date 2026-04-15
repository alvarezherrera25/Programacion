import java.util.Random;

package ejercicios_gemini_practicar;

public class finally_prueba {
    public static void main(String[] args) {
        int totalOperaciones = 1000000;
        int erroresDetectados = 0;
        Random random = new Random();

        System.out.println("Iniciando proceso masivo de " + totalOperaciones + " operaciones...");

        for (int i = 1; i <= totalOperaciones; i++) {
            try {
                // Forzamos un error aleatorio cada ciertas operaciones
                int disparadorDeError = random.nextInt(10000); // 0 a 9999
                
                if (disparadorDeError == 7) {
                    throw new ArithmeticException("¡BUM! Error matemático aleatorio.");
                }
                
                // Una operación normal
                double calculo = i / 1.5;

                // Cada 200.000 operaciones imprimimos un avance
                if (i % 200000 == 0) {
                    System.out.println("> Progreso: " + i + " operaciones procesadas...");
                }

            } catch (ArithmeticException e) {
                erroresDetectados++;
                // Aquí capturamos el error para que el millón de números siga procesándose
            } finally {
                // En un sistema real, aquí estarías registrando cada paso en un log
                // o liberando un poquito de memoria RAM.
                // Para no saturar tu consola, solo imprimiremos un mensaje al final del todo.
            }
        }

        System.out.println("\n******************************************");
        System.out.println("ANÁLISIS FINAL:");
        System.out.println("- Operaciones totales: " + totalOperaciones);
        System.out.println("- Errores capturados y controlados: " + erroresDetectados);
        System.out.println("- Estado del programa: SEGURO (gracias al try-catch)");
        System.out.println("******************************************");
    }
}