package Progtema5;

public class Progtema5_6_objeto {
    public static void main(String[] args) {
        
        Hora miReloj = new Hora(23, 50, 50);
        System.out.println("Hora inicial: " + miReloj.imprimir());

        // 1. Sumar tiempo directamente pasando los números
        miReloj.sumar(0, 10, 20); 
        System.out.println("Después de sumar: " + miReloj.imprimir());
        // 1. Restar tiempo directamente
        miReloj.restar(0, 2, 0);
        System.out.println("Después de restar 2 min: " + miReloj.imprimir());
    }
}
