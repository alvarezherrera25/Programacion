package Ejercicios_Finales.segund_evaluacion.ejercicio_11;

public class Perro implements Animal {
    private String raza;
    private String comida;

    public Perro(String raza, String comida) {
        this.raza = raza;
        this.comida = comida.toLowerCase();
    }

    public double precio() {
        if (this.comida.equals("lata")) {
            return Animal.PRECIO_BASE * 1.10;
        } else {
            return Animal.PRECIO_BASE;
        }
    }

    public String toString() {
        return "Perro: " + this.raza + " comida: " + this.comida;
    }
}
