package Ejercicios_Finales.tercer_evaluacion.ejercicio_2;

public class Venta {
    String fecha, cliente;
    double importe;
    boolean cobrada;

    public Venta(String fecha, double importe, String cliente, boolean cobrada) {
        this.fecha = fecha;
        this.importe = importe;
        this.cliente = cliente;
        this.cobrada = cobrada;
    }

    @Override
    public String toString() {
        return fecha + "," + importe + "," + cliente + "," + cobrada;
    }
}