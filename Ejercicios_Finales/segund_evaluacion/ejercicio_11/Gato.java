package Ejercicios_Finales.segund_evaluacion.ejercicio_11;

public class Gato implements Animal {
    private String raza;
    private boolean garras;

    public Gato(String raza, boolean garras) {
        this.raza = raza;
        this.garras = garras;
    }

    public double precio() {
        if (this.garras) {
            return Animal.PRECIO_BASE * 0.95; // con garras -5%
        } else {
            return Animal.PRECIO_BASE;
        }
    }

    public String toString() {
        return "Gato: " + this.raza + " tiene garras: " + this.garras;
    }
}
