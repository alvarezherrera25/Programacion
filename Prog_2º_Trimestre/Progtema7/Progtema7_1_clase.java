package Progtema7;
class empleados {

    private String nombre;
    private double sueldo;

    public empleados(String nombre, double sueldo) {
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
        System.out.println("el empleado " + nombre + " cobra " + sueldo);
    }
}
    class jefe extends empleados {

        private String titulo;
        private String nombreDept;

        public jefe(String nombre, double sueldo, String titulo, String nombreDept) {
            super(nombre, sueldo);
            this.titulo = titulo;
            this.nombreDept = nombreDept;
        }

        @Override
        public void mostrarDetalles() {
            System.out.println("el jefe " + getNombre() + " del departamento " + nombreDept + " cobra " + getSueldo()
                    + " tiene el titulo " + titulo);
        }
    }
