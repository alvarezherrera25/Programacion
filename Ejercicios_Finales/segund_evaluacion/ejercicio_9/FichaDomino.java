package Ejercicios_Finales.segund_evaluacion.ejercicio_9;

public class FichaDomino {
    public int lado1;
    public int lado2;

    public FichaDomino(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public boolean esDoble() {
        return lado1 == lado2;
    }

    public boolean esCompatible(FichaDomino otra) {
        return this.lado1 == otra.lado1 || this.lado1 == otra.lado2 ||
               this.lado2 == otra.lado1 || this.lado2 == otra.lado2;
    }

    @Override
    public String toString() {
        return "[" + lado1 + "|" + lado2 + "]";
    }
}
