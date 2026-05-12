package Ejercicios_Finales.segund_evaluacion.ejercicio_6;

public class Fraccion {
    private int numerador;
    private int denominador;
    private int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion simplificar() {
        int mcd = mcd(numerador, denominador);
        return new Fraccion(numerador / mcd, denominador / mcd);
    }

    public Fraccion suma(Fraccion f) {
        int nuevoNumerador = numerador * f.denominador + f.numerador * denominador;
        int nuevoDenominador = denominador * f.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplica(Fraccion f) {
        int nuevoNumerador = numerador * f.numerador;
        int nuevoDenominador = denominador * f.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion divide(Fraccion f) {
        int nuevoNumerador = numerador * f.denominador;
        int nuevoDenominador = denominador * f.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    @Override
    public String toString() {
    return numerador + "/" + denominador;
}
}
