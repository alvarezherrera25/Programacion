package Ejercicios_Finales.segund_evaluacion.ejercicio_10;

public class Baraja {
    private Carta[] cartas;
    private static int indice = 0;

    public Baraja() {
        cartas = new Carta[40];
        for (int palo = 1; palo <= 4; palo++) {
            for (int numero = 1; numero <= 10; numero++) {
                cartas[indice] = new Carta(palo, numero);
                indice++;
            }
        }
    }

    public Carta[] sacarCartas(int cantidad) {
        Carta[] seleccion = new Carta[cantidad];
        for (int i = 0; i < cantidad; i++) {
            int indiceAleatorio;
            do {
                indiceAleatorio = (int) (Math.random() * cartas.length);
            } while (cartas[indiceAleatorio] == null);
            seleccion[i] = cartas[indiceAleatorio];
            cartas[indiceAleatorio] = null;
        }
        return seleccion;
    }
}
