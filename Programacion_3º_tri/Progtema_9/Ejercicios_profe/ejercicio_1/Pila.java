package ejercicio_1;

class Pila {
 
    private int[] datos = new int[100];
    private int cima = -1;
 
    public void push(int valor) throws Exception {
        if (cima == 99) {
            throw new IllegalStateException("Stack Overflow Pila llena.");
        }
        cima++;
        datos[cima] = valor;
    }
 
    public int pop() throws Exception {
        if (estaVacia()) {
            throw new IllegalStateException("Stack Underflow Pila vacia.");
        }
        int valor = datos[cima];
        cima--;
        return valor;
    }
 
    public int size() {
        return cima + 1;
    }
 
    public boolean estaVacia() {
        return cima == -1;
    }
}