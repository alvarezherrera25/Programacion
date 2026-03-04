package Progtema7.ejercicio_4_tema_7;

import java.util.Scanner;

public class Empleado {
    private String nombre;
    private double sueldo;

    public Empleado() {}

    public void pedirDatos(Scanner sc) {
        System.out.print("Nombre: ");
        this.nombre = sc.nextLine();
        System.out.print("Sueldo: ");
        this.sueldo = sc.nextDouble();
        sc.nextLine(); 
    }

    public String getNombre() { return nombre; }
    public double getSueldo() { return sueldo; }

    public void mostrarDetalles() {
        System.out.println("[Empleado] " + nombre + " | Sueldo: " + sueldo + "€");
    }
}

