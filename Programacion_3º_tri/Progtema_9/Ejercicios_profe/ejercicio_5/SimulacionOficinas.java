package ejercicio_5;
/*
Tenemos 5 ventanillas de atencion al cliente, cada una genera una cola de espera.
Cada nodo de informacion que se inserta tiena una tarea que dura 15, 20 o 30 minutos (aleatorio). Un 60% de las tareas duran 15 minutos, 
un 25% duran 20 minutos y un 15% duran 30 minutos.

El programa debe crear un nodo de tipo 15,20 o 30. Usar un generador de numeros aleatorios valores entre 1 al 100.
Si el numero generado esta entre 1 y 60 la tarea dura 15 minutos, si esta entre 61 y 85 dura 20 minutos y si esta entre 86 y 100 dura 30 minutos.
Cuando se crea un nodo o cliente se asigna a la cola de menor tamaño.
Se estima que cada 5 minutos llega un nuevo cliente.
Debe simular 5 horas de atencion al cliente.  Un buble de 1 a 300 minutos, para cada minuto hay que;
1. Si el minuto es múltiplo de 5 generar un cliente (tarea/nodo) y ponerlo en la cola correspondiente; si dos
o más colas tienen la misma longitud, se puede poner en cualquiera.
2. Dar servicio a las 5 ventanillas: descontar el minuto que ha transcurrido a las tareas que están en el frente
de cada cola y suprimirlas de la cola cuando llegan a cero.

El programa debe darnos el tamaño de cada cola cada 15 min. Y al final la longitud media de cada cola
(Distacion de la cola en cada instante / numero de instantes).

Autor: Hugo Álvarez
Fecha: 2024-06-10
 */
import java.util.*;
public class SimulacionOficinas {
    public static void main(String[] args) {
        // 1. Creamos las 5 ventanillas (colas de enteros que representan minutos)
        List<Queue<Integer>> ventanillas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ventanillas.add(new LinkedList<>());
        }

        // Variables para las estadísticas (sumar longitudes en cada minuto)
        int[] sumaLongitudes = new int[5];
        int tiempoTotal = 300; // 5 horas * 60 min

        // BUCLE PRINCIPAL (1 a 300 minutos)
        for (int minuto = 1; minuto <= tiempoTotal; minuto++) {

            // PASO 1: Si es múltiplo de 5, llega un cliente nuevo
            if (minuto % 5 == 0) {
                int duracion = generarDuracionTarea();
                asignarAColaMinima(ventanillas, duracion);
            }

            // PASO 2: Dar servicio en las 5 ventanillas
            for (int i = 0; i < 5; i++) {
                Queue<Integer> cola = ventanillas.get(i);
                
                if (!cola.isEmpty()) {
                    // Obtenemos la tarea del frente
                    int tiempoRestante = cola.peek();
                    tiempoRestante--; // Descontamos un minuto

                    if (tiempoRestante <= 0) {
                        cola.poll(); // Tarea terminada, sale de la cola
                    } else {
                        // Actualizamos el valor en el frente (sacar y volver a poner delante)
                        // En LinkedList es más fácil usar una lógica de actualizar el objeto
                        // pero como son Integers (inmutables), hacemos poll y addFirst:
                        ((LinkedList<Integer>) cola).set(0, tiempoRestante);
                    }
                }
                // Acumulamos la longitud actual para la media final
                sumaLongitudes[i] += cola.size();
            }

            // MOSTRAR ESTADO CADA 15 MINUTOS
            if (minuto % 15 == 0) {
                System.out.println("Minuto " + minuto + " ---------------------------");
                for (int i = 0; i < 5; i++) {
                    System.out.println("Ventanilla " + (i + 1) + ": " + ventanillas.get(i).size() + " clientes");
                }
            }
        }

        // RESULTADOS FINALES
        System.out.println("\n=== LONGITUD MEDIA FINAL (TRAS 5 HORAS) ===");
        for (int i = 0; i < 5; i++) {
            double media = (double) sumaLongitudes[i] / tiempoTotal;
            System.out.printf("Ventanilla %d: %.2f clientes de media\n", (i + 1), media);
        }
    }

    // Método para generar la duración según los porcentajes del enunciado
    public static int generarDuracionTarea() {
        int aleatorio = (int) (Math.random() * 100) + 1;
        if (aleatorio <= 60) return 15;
        if (aleatorio <= 85) return 20;
        return 30;
    }

    // Método para buscar la cola más corta y meter al cliente
    public static void asignarAColaMinima(List<Queue<Integer>> ventanillas, int duracion) {
        int indiceMinimo = 0;
        int minTamano = ventanillas.get(0).size();

        for (int i = 1; i < ventanillas.size(); i++) {
            if (ventanillas.get(i).size() < minTamano) {
                minTamano = ventanillas.get(i).size();
                indiceMinimo = i;
            }
        }
        ventanillas.get(indiceMinimo).add(duracion);
    }
}
    

