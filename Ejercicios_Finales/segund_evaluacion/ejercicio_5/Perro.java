package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Perro {
    private String nombre;
    private int edad;

    public Perro(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void ladrar() {
        System.out.println(nombre + " está ladrando.");
    }

    public void correr() {
        System.out.println(nombre + " está corriendo.");
    }

    public void jugar() {
        System.out.println(nombre + " está jugando con una pelota.");
    }
}
