package Ejercicios_Finales.segund_evaluacion.ejercicio_5;

public class Mamifero {
    private String nombre;
    private int edad;

    public Mamifero(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void amamantar() {
        System.out.println(nombre + " está amamantando a sus crías.");
    }

    public void caminar() {
        System.out.println(nombre + " está caminando.");
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido característico de los mamíferos.");
    }
}
