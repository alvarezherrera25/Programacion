package ejercicios_gemini_practicar.pilas;

public class Nodo<T> {
    T dato;
    Nodo<T> enlace;

    // Constructor para facilitar la creación
    public Nodo(T dato) {
        this.dato = dato;
        this.enlace = null;
    }
}
