package Ejercicios_Finales.tercer_evaluacion.ejercicio_2;
import java.util.*;
import java.io.*;

public class Viajante {
    private String dni;
    private String nombre;
    private int antiguedad;
    private double distanciaRecorrida;
    private ArrayList<Venta> ventas;

    public Viajante(String dni, String nombre, int antiguedad) {
        this.dni = dni;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.distanciaRecorrida = 0;
        this.ventas = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void incrementarDistancia(double km) {
        this.distanciaRecorrida += km;
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public void mostrarViajante() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Antigüedad: " + antiguedad + " años");
        System.out.println("Distancia Recorrida: " + distanciaRecorrida + " km");
        System.out.println("Ventas:");
        for (Venta venta : ventas) {
            venta.mostrarVenta();
            System.out.println();
        }
    }
 }
