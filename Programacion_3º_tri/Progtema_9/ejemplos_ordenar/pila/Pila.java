package Programacion_3º_tri.Progtema_9.ejemplos_ordenar.pila;

public class Pila {
    public static int MAXIMO = 100;
    public Elemento[] v;
    private int cima;

    public Pila(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad inválida");
        }
        v = new Elemento[capacidad];
        cima = 0;
    }

    public Pila() {
        this(MAXIMO); 
    }

    // --- LOS MÉTODOS QUE FALTABAN ---

    public void apilar(Elemento e) {
        if (cima < v.length) {
            v[cima] = e; // Mete el elemento en el hueco
            cima++;      // Sube la cima
        } else {
            System.out.println("Error: La pila ya está llena.");
        }
    }

    public Elemento desapilar() {
        if (cima > 0) {
            cima--;         // Baja la cima
            return v[cima]; // Devuelve el elemento
        } else {
            System.out.println("Error: La pila está vacía.");
            return null;
        }
    }
}
