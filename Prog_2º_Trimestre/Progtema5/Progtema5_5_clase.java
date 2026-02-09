package Progtema5;

class Indicador {
    // Atributo: Solo necesitamos guardar el valor actual
    private double valor;
    // Constructor: Se ejecuta al crear el objeto para dar el valor de inicio
    public Indicador(double valorInicial){
        this.valor = valorInicial;
    }
    // Método para imprimir el valor en consola
    public void imprimirValor(){
        System.out.println("Valor actual del indicardor: " + this.valor);
    }
    // Método para cambiar el valor directamente
    public void cambiarValor(double nuevoValor){
        this.valor = nuevoValor;
    }
    // Método para sumar al valor actual
    public void incrementar(double cantidad){
        this.valor += cantidad;
    }
    // Método para restar al valor actual
    public void disminuir(double cantidad){
        this.valor -= cantidad;
    }
}
