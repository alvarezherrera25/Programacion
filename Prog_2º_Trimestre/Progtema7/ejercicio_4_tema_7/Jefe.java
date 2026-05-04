package Progtema7.ejercicio_4_tema_7;


import java.util.Scanner;

class Jefe extends Empleado {
    private String titulo;
    private String nombreDept;

    public Jefe() {
        super(); 
    }

    @Override
    public void pedirDatos(Scanner sc) {
        super.pedirDatos(sc); 
        
        System.out.print("Título: ");
        this.titulo = sc.nextLine();
        System.out.print("Departamento: ");
        this.nombreDept = sc.nextLine();
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Jefe] " + getNombre() + " | Dept: " + nombreDept + 
                           " | Título: " + titulo + " | Sueldo: " + getSueldo() + "€");
    }
}