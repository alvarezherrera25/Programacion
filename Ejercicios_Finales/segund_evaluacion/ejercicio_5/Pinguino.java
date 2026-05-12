package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Pinguino {
    private String nombre;
    private int edad;

    public Pinguino(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void nadar() {
        System.out.println(nombre + " está nadando en el agua.");
    }

    public void deslizarse() {
        System.out.println(nombre + " se está deslizando sobre el hielo.");
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido característico de los pingüinos.");
    }
}
