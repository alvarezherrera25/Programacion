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
    static HashMap<String, Viajante> lista = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargar();
        int op;
        do {
            System.out.print(
            "1.Añadir\n 2.Eliminar\n 3.Listar\n 4.Reiniciar\n 5.+Km\n 6.+Venta\n 7.Cobrar\n 8.Pendientes\n 9.Salir: ");
            op = sc.nextInt(); sc.nextLine();
            
            switch (op) {
                case 1 -> {
                    System.out.print("DNI, Nombre, Antigüedad: ");
                    String d = sc.next(); String n = sc.next(); int a = sc.nextInt();
                    lista.put(d, new Viajante(d, n, a, 0));
                }
                case 2 -> {
                    System.out.print("DNI a borrar: ");
                    lista.remove(sc.next());
                }
                case 3 -> {
                    for (Viajante v : lista.values()) 
                        System.out.println(v.dni + " - " + v.nombre + " - Km: " + v.km + " - Cobrado: " + v.totalCobrado());
                }
                case 4 -> {
                    try (PrintWriter pw = new PrintWriter(new FileWriter("E:\\HugoAH\\Programacion\\Ejercicios_Finales\\tercer_evaluacion\\ejercicio_2\\Historico.txt", true))) {
                        for (Viajante v : lista.values()) {
                            v.km = 0;
                            v.ventas.removeIf(ven -> {
                                if (ven.cobrada) {
                                    pw.println(v.dni + "," + ven);
                                    return true;
                                }
                                return false;
                            });
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                }
                case 5 -> {
                    System.out.print("DNI y Km: ");
                    Viajante v = lista.get(sc.next());
                    if (v != null) v.km += sc.nextDouble();
                }
                case 6 -> {
                    System.out.print("DNI, Fecha, Importe, Cliente: ");
                    Viajante v = lista.get(sc.next());
                    if (v != null) v.ventas.add(new Venta(sc.next(), sc.nextDouble(), sc.next(), false));
                }
                case 7 -> {
                    System.out.print("DNI: ");
                    Viajante v = lista.get(sc.next());
                    if (v != null) {
                        for (int i = 0; i < v.ventas.size(); i++) 
                            if (!v.ventas.get(i).cobrada) System.out.println(i + ": " + v.ventas.get(i));
                        System.out.print("Nº de venta: ");
                        v.ventas.get(sc.nextInt()).cobrada = true;
                    }
                }
                case 8 -> {
                    System.out.print("DNI: ");
                    Viajante v = lista.get(sc.next());
                    if (v != null) for (Venta ven : v.ventas) if (!ven.cobrada) System.out.println(ven);
                }
            }
        } while (op != 9);
        guardar();
    }

    static void cargar() {
        try {
            Scanner sV = new Scanner(new File("E:\\HugoAH\\Programacion\\Ejercicios_Finales\\tercer_evaluacion\\ejercicio_2\\Viajante.txt"));
            while (sV.hasNextLine()) {
                String[] d = sV.nextLine().split(",");
                lista.put(d[0], new Viajante(d[0], d[1], Integer.parseInt(d[2]), Double.parseDouble(d[3])));
            }
            Scanner sVen = new Scanner(new File("Ventas.txt"));
            while (sVen.hasNextLine()) {
                String[] d = sVen.nextLine().split(",");
                if (lista.containsKey(d[0])) 
                    lista.get(d[0]).ventas.add(new Venta(d[1], Double.parseDouble(d[2]), d[3], Boolean.parseBoolean(d[4])));
            }
        } catch (Exception e) { System.out.println("Iniciando archivos nuevos..."); }
    }

    static void guardar() {
        try (PrintWriter pVi = new PrintWriter("E:\\HugoAH\\Programacion\\Ejercicios_Finales\\tercer_evaluacion\\ejercicio_2\\Viajante.txt"); 
             PrintWriter pVe = new PrintWriter("E:\\HugoAH\\Programacion\\Ejercicios_Finales\\tercer_evaluacion\\ejercicio_2\\Ventas.txt")) {
            for (Viajante v : lista.values()) {
                pVi.println(v.dni + "," + v.nombre + "," + v.antiguedad + "," + v.km);
                for (Venta ven : v.ventas) pVe.println(v.dni + "," + ven);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}