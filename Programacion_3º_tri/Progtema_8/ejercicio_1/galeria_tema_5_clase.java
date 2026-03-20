package Programacion_3º_tri.Progtema_8.ejercicio_1;

class galeria {
    private String nombre;
    private int fecha;
    private double cantidad;

    public galeria(String nombre, int fecha, double cantidad) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (fecha <= 0) {
            throw new IllegalArgumentException("La fecha no puede ser negativa");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        this.nombre = nombre;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFecha() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String verDatos() {
        return "Nombre :" + nombre + " | Fecha: " + fecha + " | Cantidad: " + cantidad;
    }
}
