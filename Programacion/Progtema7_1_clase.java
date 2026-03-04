package Progtema7;

class Empleado {
    private String nombre;
    private double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void mostrarDetalles() {
        System.out.println("El empleado " + nombre + " cobra " + sueldo);
    }
}

class Jefe extends Empleado {
    private String titulo;
    private String nombreDept;

    public Jefe(String nombre, double sueldo, String titulo, String nombreDept) {
        super(nombre, sueldo);
        this.titulo = titulo;
        this.nombreDept = nombreDept;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("El jefe " + getNombre() + " del departamento " + nombreDept + " cobra " + getSueldo()
                + " y tiene el titulo " + titulo);
    }
}