package Ejercicios_Finales.tercer_evaluacion.ejercicio_2;
import java.util.ArrayList;

public class Viajante {
    String dni, nombre;
    int antiguedad;
    double km;
    ArrayList<Venta> ventas = new ArrayList<>();

    public Viajante(String dni, String nombre, int ant, double km) {
        this.dni = dni;
        this.nombre = nombre;
        this.antiguedad = ant;
        this.km = km;
    }

    public double totalCobrado() {
        double total = 0;
        for (Venta v : ventas) if (v.cobrada) total += v.importe;
        return total;
    }
}