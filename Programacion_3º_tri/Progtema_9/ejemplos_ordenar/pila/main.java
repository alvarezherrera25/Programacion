package Programacion_3º_tri.Progtema_9.ejemplos_ordenar.pila;

public class main {
    public static void main(String[] args) {
        
        // 1. Creamos una pila pequeña
        Pila miPila = new Pila(3);
        
        // 2. Apilamos 3 elementos
        miPila.apilar(new Elemento(10));
        miPila.apilar(new Elemento(20));
        miPila.apilar(new Elemento(30));
        
        // 3. Desapilamos y mostramos por pantalla (LIFO: saldrá el 30, 20, 10)
        System.out.println("Sale: " + miPila.desapilar());
        System.out.println("Sale: " + miPila.desapilar());
        System.out.println("Sale: " + miPila.desapilar());
    }
}