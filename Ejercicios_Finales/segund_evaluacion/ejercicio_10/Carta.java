package Ejercicios_Finales.segund_evaluacion.ejercicio_10;

public class Carta {
    private int palo;
    private int numero;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public int getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    public String toString() {
        String[] palos = { "bastos", "oros", "copas", "espadas" };
        String[] numeros = { "as", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey" };
        return numeros[numero - 1] + " de " + palos[palo - 1];
    }
}
