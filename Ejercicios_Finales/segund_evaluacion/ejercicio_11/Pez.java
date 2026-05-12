package Ejercicios_Finales.segund_evaluacion.ejercicio_11;

/*Tipo de pez y agua dulce o salada */
public class Pez implements Animal {
    private String tipoPez;
    private boolean aguaDulce;

    public Pez(String tipoPez, boolean aguaDulce) {
        this.tipoPez = tipoPez;
        this.aguaDulce = aguaDulce;
    }

    public double precio() {
        if (this.aguaDulce) {
            return Animal.PRECIO_BASE * 1.20;
        } else {
            return Animal.PRECIO_BASE;
        }
    }

    public String toString() {
        return "Pez: " + this.tipoPez + " agua dulce: " + this.aguaDulce;
    }
}
