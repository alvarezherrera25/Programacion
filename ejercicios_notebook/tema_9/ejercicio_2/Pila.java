package ejercicios_notebook.tema_9.ejercicio_2;

public class Pila<T> { 

    // Clase interna para los nodos (encapsulación) [3, 5]
    private class Nodo {
        T dato;       // El componente que almacena el dato [7]
        Nodo enlace;  // Referencia al siguiente nodo de la estructura [3, 7]

        Nodo(T e) {
            this.dato = e;
            this.enlace = null;
        }
    }

    // Referencia externa al nodo superior de la pila [3]
    private Nodo cima = null; 

    // Operación apilar (push): inserta al principio de la estructura [8, 9]
    public void apilar(T e) {
        Nodo nuevo = new Nodo(e); // Crea el nuevo nodo con el dato [8, 9]
        nuevo.enlace = cima;      // El nuevo nodo apunta a la antigua cima [8, 9]
        cima = nuevo;             // Actualizamos la cima al nuevo nodo [8, 9]
    }

    // Operación desapilar (pop): retira el elemento superior [9]
    public T desapilar() {
        if (vacia()) {
            return null; // En una implementación robusta se lanzaría una excepción [10]
        }
        T x = cima.dato;    // Recuperamos el dato de la cima [9]
        cima = cima.enlace; // El nodo de debajo pasa a ser la nueva cima [9]
        return x;           // Devolvemos el dato recuperado [9]
    }

    // Comprobar si la pila está vacía [9, 11]
    public boolean vacia() {
        return cima == null; // Si la referencia externa es null, la lista está vacía [8, 9]
    }
}
