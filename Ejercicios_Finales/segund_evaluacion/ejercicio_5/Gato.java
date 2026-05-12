package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Gato {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void maullar() {
        System.out.println(nombre + " está maullando.");
    }

    public void cazar() {
        System.out.println(nombre + " está cazando.");
    }

    public void dormir() {
        System.out.println(nombre + " está durmiendo en un lugar cómodo.");
    }   
}
