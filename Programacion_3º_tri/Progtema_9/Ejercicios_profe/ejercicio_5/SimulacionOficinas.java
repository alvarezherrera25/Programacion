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
        List<Queue<Integer>> ventanillas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ventanillas.add(new LinkedList<>());
        }
        
        int[] sumaLongitudes = new int[5];
        int timepoTotal = 300;

        //Bucle principal (1 a 300 min)
        for (int minuto = 1; minuto <= timepoTotal; minuto++) {
            
        }
    }
}
