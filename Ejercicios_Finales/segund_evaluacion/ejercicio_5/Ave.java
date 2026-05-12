package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Ave {
    private String nombre;
    private int edad;

    public Ave(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void volar() {
        System.out.println(nombre + " está volando.");
    }

    public void cantar() {
        System.out.println(nombre + " está cantando.");
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido característico de las aves.");
    }
}
