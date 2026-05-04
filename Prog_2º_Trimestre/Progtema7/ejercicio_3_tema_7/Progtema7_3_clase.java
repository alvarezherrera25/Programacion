package Progtema7.ejercicio_3_tema_7;

class empleados {
    public static final String NOM_EMPRESA = "Eléctrica, SA";
    private static double sueldoBase = 1000.0;

    private String nombre;
    private int edad;
    private double increSueldo;

    public empleados(String nombre, int edad, double increSueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.increSueldo = increSueldo;
    }

    public static void setSueldoBase(double nuevoSueldo) { sueldoBase = nuevoSueldo; }
    public static double getSueldoBase() { return sueldoBase; }
    public String getNombre() { return nombre; }
    
    public double calcularSueldoFinal() {
        return sueldoBase + (sueldoBase * (increSueldo / 100));
    }

    public void mostrarDetalles() {
        System.out.println("[" + NOM_EMPRESA + "] Empleado: " + nombre + " | Edad: " + edad + 
                           " | Sueldo Final: " + calcularSueldoFinal() + "€");
    }
}

class jefe extends empleados {
    private static double plusJefe = 250.0;
    private String nombreDept;

    public jefe(String nombre, int edad, double increSueldo, String nombreDept) {
        super(nombre, edad, increSueldo); 
        this.nombreDept = nombreDept;
    }

    public static void setPlusJefe(double nuevoPlus) { plusJefe = nuevoPlus; }
    public static double getPlusJefe() { return plusJefe; }

    @Override
    public void mostrarDetalles() {
        double sueldoTotal = calcularSueldoFinal() + plusJefe;
        System.out.println("[" + NOM_EMPRESA + "] JEFE: " + getNombre() + " | Dept: " + nombreDept + 
                           " | Sueldo Final: " + sueldoTotal + "€");
    }
}