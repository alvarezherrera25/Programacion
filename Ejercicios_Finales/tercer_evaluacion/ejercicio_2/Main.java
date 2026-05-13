package Ejercicios_Finales.tercer_evaluacion.ejercicio_2;
/*
Una empresa de ventas desea gestionar el control de viajantes de la misma. Para cada viajante, controla:
• DNI
• Nombre
• Antigüedad
• Distancia recorrida (Km)
• Ventas realizadas
Las ventas contienen la información siguiente:
• Fecha
• Importe
• Cliente
• Cobrada (según se haya ingresado su importe o no)
Crear un programa que muestre un menú y permita:
1. Añadir un viajante
2. Eliminar un viajante
3. Mostrar un listado de todos los viajantes, indicando la distancia recorrida y el importe acumulado de
las ventas cobradas
4. Inicializar ventas: la distancia recorrida de todos los viajantes pasará a ser cero y las ventas cobradas
de todos ellos se almacenarán en el histórico, eliminándolas (del programa)
5. Incrementar la distancia recorrida por un viajante (deberá pedir el número de kilómetros recorridos)
6. Añadir una venta de un viajante
7. Cobrar una venta de un viajante
8. Mostrar un listado de todas las ventas no cobradas de un viajante
8. Terminar el programa
Los datos de los viajantes deben ser leídos de un fichero al inicio de la ejecución del programa, si dicho
fichero existe. Análogamente, serán almacenados en dicho fichero antes de finalizar el programa que, si no
existía, será creado en ese momento. Existirán dos ficheros más: de histórico de ventas y de ventas; el
programa solo leerá, al inicio, el de ventas, si existe, y almacenará en el mismo los datos antes de finalizar.
El histórico de ventas almacenará las ventas cobradas hasta el momento de inicialización de ventas (opción
4): si no existe, se creará; si existe, se añadirán las ventas al fichero actual.
*/
// Crearemos tres clases: Viajante, Venta y Main.
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Viajante> viajantes = new HashMap<>(); 
    }
}
