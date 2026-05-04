package Progtema7.ejercicio_4_tema_7;

import java.util.Scanner;

public class Progtema7_4_objeto {
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
            listaEmpleados[i] = new Empleado(); 
            listaEmpleados[i].pedirDatos(sc);
        }

        for (int i = 0; i < nJef; i++) {
            System.out.println("\n--- Datos Jefe " + (i + 1) + " ---");
            listaJefes[i] = new Jefe(); 
            listaJefes[i].pedirDatos(sc);
        }

        System.out.println("\n========================================");
        System.out.println("        RESULTADOS DE LA EMPRESA");
        System.out.println("========================================");

        for (int i = 0; i < nEmp; i++) listaEmpleados[i].mostrarDetalles();
        for (int i = 0; i < nJef; i++) listaJefes[i].mostrarDetalles();

    }
}