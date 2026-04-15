package Programacion_3º_tri.Progtema_9.Ejercicios_profe.ejercicio_1;

public class main {

    public static void main(String[] args) {
 
        Pila pila = new Pila();
 
        // Numeros que vamos a insertar
        int[] numerosParaInsertar = {34, 7, 85, 12, 60, 3, 47, 91, 25, 78,
                                     55, 19, 63, 40, 8, 72, 31, 50, 96, 14};
 
        // ── FASE 1: Insertar todos los numeros ──
        System.out.println("  FASE 1 - Insertando numeros en la pila");
        System.out.println();
 
        for (int i = 0; i < numerosParaInsertar.length; i++) {
            try {
                pila.push(numerosParaInsertar[i]);
                System.out.println("  push(" + numerosParaInsertar[i] + ")  ->  elementos en pila: " + pila.size());
            } catch (Exception e) {
                System.out.println("  Error al insertar: " + e.getMessage());
            }
        }
 
        // ── FASE 2: Extraer 5 elementos ──
        System.out.println();
        System.out.println("  FASE 2 - Extrayendo 5 elementos");
        System.out.println();
 
        for (int i = 0; i < 5; i++) {
            try {
                int extraido = pila.pop();
                System.out.println("  pop()  ->  extraido: " + extraido + "  |  restantes: " + pila.size());
            } catch (Exception e) {
                System.out.println("  Error al extraer: " + e.getMessage());
            }
        }
 
        // ── FASE 3: Insertar 4 numeros mas ──
        System.out.println();
        System.out.println("  FASE 3 - Insertando 4 numeros mas");
        System.out.println();
 
        int[] segundaTanda = {100, 200, 300, 400};
 
        for (int i = 0; i < segundaTanda.length; i++) {
            try {
                pila.push(segundaTanda[i]);
                System.out.println("  push(" + segundaTanda[i] + ")  ->  elementos en pila: " + pila.size());
            } catch (Exception e) {
                System.out.println("  Error al insertar: " + e.getMessage());
            }
        }
 
        // ── Estado final antes de vaciar ──
        System.out.println();
        System.out.println("  ESTADO FINAL: " + pila.size() + " elementos en la pila");
        System.out.println();
 
        // ── VACIADO: mostrar todos los elementos extrayendolos (LIFO) ──
        System.out.println();
        System.out.println("  VACIADO - Ultimo en entrar, primero en salir");
        System.out.println();
 
        int orden = 1;
        while (!pila.estaVacia()) {
            try {
                System.out.println("  " + orden + ". pop()  ->  " + pila.pop());
                orden++;
            } catch (Exception e) {
                System.out.println("  Error al vaciar: " + e.getMessage());
            }
        }
 
        System.out.println();
        System.out.println("  Pila vaciada. Elementos restantes: " + pila.size());
    }
}