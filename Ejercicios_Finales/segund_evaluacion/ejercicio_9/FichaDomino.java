package Ejercicios_Finales.segund_evaluacion.ejercicio_9;

public class FichaDomino {
    private int lado1;
    private int lado2;

    public FichaDomino(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public boolean esDoble() {
        return lado1 == lado2;
    }

    public boolean encaja(FichaDomino otra) {
        return this.lado1 == otra.lado1 || this.lado1 == otra.lado2 ||
                this.lado2 == otra.lado1 || this.lado2 == otra.lado2;
    }

    public void girar() {
        int aux = this.lado1;
        this.lado1 = this.lado2;
        this.lado2 = aux;
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public String toString() {
        return "[" + lado1 + "|" + lado2 + "]";
    }
}
