package Progtema5;

public class Progtema5_5_objeto {
    public static void main (String[] args){
        // 1. Crear el indicador iniciando en 0
        Indicador miIndicador = new Indicador(0);
        // 2. Imprimir valor inicial
        miIndicador.imprimirValor();
        // 3. Modificar a un valor fijo
        System.out.println("---------------------------------------");
        System.out.println("Cambiar valor a 100");
        miIndicador.cambiarValor(100);
        miIndicador.imprimirValor();
        // 4. Incrementar (Sumar)
        System.out.println("---------------------------------------");
        System.out.println("Incrementar valor en 20");
        miIndicador.incrementar(20);
        miIndicador.imprimirValor();
        // 5. Disminuir (Restar)
        System.out.println("---------------------------------------");
        System.out.println("Disminuir valor en 50");
        miIndicador.disminuir(50);
        miIndicador.imprimirValor();
    }
}
