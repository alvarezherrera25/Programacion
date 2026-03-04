package Progtema7.ejercicio_3_tema_7;
import java.util.Scanner;


public class Progtema7_3_objeto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos empleados normales? ");
        int nEmp = sc.nextInt();
        System.out.print("¿Cuántos jefes? ");
        int nJef = sc.nextInt();
        sc.nextLine(); 

        empleados[] plantilla = new empleados[nEmp + nJef];
        int indice = 0;

        for (int i = 0; i < nEmp; i++) {
            System.out.println("\n--- Datos Empleado " + (i + 1) + " ---");
            System.out.print("Nombre: "); 
            String nombre = sc.nextLine();
            System.out.print("Edad: "); 
            int edad = sc.nextInt();
            System.out.print("% Incremento: "); 
            double incre = sc.nextDouble();
            sc.nextLine(); 
            plantilla[i] = new empleados(nombre, edad, incre);
        }

        for (int i = 0; i < nJef; i++) {
            System.out.println("--- Datos Jefe " + (i + 1) + " ---");
            System.out.print("Nombre: "); 
            String nombre = sc.nextLine();
            System.out.print("Edad: "); 
            int edad = sc.nextInt();
            System.out.print("% Incremento: "); 
            double incre = sc.nextDouble();
            sc.nextLine(); 
            System.out.print("Departamento: "); 
            String nombreDept = sc.nextLine();
            plantilla[i] = new jefe(nombre, edad, incre, nombreDept);
        }

        int opcion;
        do {
            System.out.println("********** MENÚ ELÉCTRICA, SA **********");
            System.out.println("1. Modificar sueldo base");
            System.out.println("2. Modificar plus jefes");
            System.out.println("3. Visualizar todos");
            System.out.println("4. Salir");
            System.out.print("ELIJA OPCIÓN: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo sueldo base: ");
                    empleados.setSueldoBase(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Nuevo plus jefe: ");
                    jefe.setPlusJefe(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("--- LISTADO DE PLANTILLA ---");
                    for (int i = 0; i < (nEmp + nJef); i++) {
                        plantilla[i].mostrarDetalles();
                    }
                    break;
            }
        } while (opcion != 4);
    }
}