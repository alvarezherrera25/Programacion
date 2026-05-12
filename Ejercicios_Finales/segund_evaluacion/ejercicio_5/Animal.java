package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }   

    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido.");
    }
}
