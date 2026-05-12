package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Lagarto {
    private String nombre;
    private int edad;

    public Lagarto(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void arrastrarse() {
        System.out.println(nombre + " se está arrastrando.");
    }

    public void tomarElSol() {
        System.out.println(nombre + " está tomando el sol.");
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido característico de los lagartos.");
    }
}
