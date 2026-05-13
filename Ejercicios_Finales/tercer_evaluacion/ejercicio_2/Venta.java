package Ejercicios_Finales.tercer_evaluacion.ejercicio_2;
import java.util.*;
import java.io.*;

public class Venta {
    private String fecha;
    private double importe;
    private String cliente;
    private boolean cobrada;

    public Venta(String fecha, double importe, String cliente) {
        this.fecha = fecha;
        this.importe = importe;
        this.cliente = cliente;
        this.cobrada = false;
    }

    public String getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean isCobrada() {
        return cobrada;
    }

    public void cobrar() {
        this.cobrada = true;
    }

    public void mostrarVenta() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Importe: " + importe);
        System.out.println("Cliente: " + cliente);
        System.out.println("Cobrada: " + (cobrada ? "Sí" : "No"));
    }
}
