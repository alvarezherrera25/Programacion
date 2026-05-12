package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Canario {
    private String nombre;
    private int edad;

    public Canario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void cantar() {
        System.out.println(nombre + " está cantando una melodía alegre.");
    }

    public void volar() {
        System.out.println(nombre + " está volando por el cielo.");
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido característico de los canarios.");
    }
}
