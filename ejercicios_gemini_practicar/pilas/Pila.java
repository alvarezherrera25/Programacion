package ejercicios_gemini_practicar.pilas;

public class Pila<T> {
    private Nodo<T> cima;

    public Pila() {
        this.cima = null;
    }

    // El método apilar que puso el profe
    public void apilar(T e) {
        Nodo<T> aux = new Nodo<>(e);
        aux.enlace = cima; // El nuevo apunta al que estaba antes arriba
        cima = aux;        // La cima ahora es el nuevo
    }

    // El método desapilar
    public T desapilar() {
        if (cima == null) {
            throw new java.util.NoSuchElementException("Pila vacía");
        } else {
            Nodo<T> aux = cima;
            cima = aux.enlace; // La cima baja al siguiente nodo
            return aux.dato;   // Devolvemos el dato del que acabamos de quitar
        }
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
