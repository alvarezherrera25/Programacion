package Programacion_3º_tri.Progtema_9.Ejercicios_profe.ejercicio_1;

import java.util.EmptyStackException;

class Pila {
 
    private int[] datos = new int[100];
    private int cima = -1;
 
    // Apilar en la cima
    public void push(int valor) throws Exception {
        if (cima == 99) {
            throw new IllegalStateException("¡Stack Overflow! Pila llena.");
        }
        cima++;
        datos[cima] = valor;
    }
 
    // Desapilar de la cima
    public int pop() throws Exception {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        int valor = datos[cima];
        cima--;
        return valor;
    }
 
    // Numero de elementos apilados
    public int size() {
        return cima + 1;
    }
 
    // Comprueba si la pila esta vacia
    public boolean estaVacia() {
        return cima == -1;
    }
}