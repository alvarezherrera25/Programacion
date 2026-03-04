package Progtema7.ejercicio_1_tema_7;

import java.util.Scanner;

public class Progtema7_1_objeto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos empleados vas a introducir? ");
        int nEmp = sc.nextInt();
        System.out.print("¿Cuántos jefes vas a introducir? ");
        int nJef = sc.nextInt();
        sc.nextLine();

        Empleado[] listaEmpleados = new Empleado[nEmp];
        Jefe[] listaJefes = new Jefe[nJef];

        for (int i = 0; i < nEmp; i++) {
            System.out.println("\n--- Datos Empleado " + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Sueldo: ");
            double sueldo = sc.nextDouble();
            sc.nextLine();
            
            listaEmpleados[i] = new Empleado(nombre, sueldo);
        }

        for (int i = 0; i < nJef; i++) {
            System.out.println("\n--- Datos Jefe " + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Sueldo: ");
            double sueldo = sc.nextDouble();
            sc.nextLine();
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Departamento: ");
            String nombreDept = sc.nextLine();
            
            listaJefes[i] = new Jefe(nombre, sueldo, titulo, nombreDept);
        }

        System.out.println("\n========================================");
        System.out.println("        RESULTADOS DE LA EMPRESA");
        System.out.println("========================================");

        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        for (int i = 0; i < nEmp; i++) {
            listaEmpleados[i].mostrarDetalles();
        }

        System.out.println("\n--- LISTA DE JEFES ---");
        for (int i = 0; i < nJef; i++) {
            listaJefes[i].mostrarDetalles();
        }
    }
}

