package ejercicios_gemini_practicar.pilas;

public class TestPila {
    public static void main(String[] args) {
        // Creamos una pila de números enteros
        Pila<Integer> pi = new Pila<Integer>();

        pi.apilar(10);
        pi.apilar(20);
        pi.apilar(30);

        System.out.println("Extrayendo de la pila: " + pi.desapilar()); // 30
        System.out.println("Extrayendo de la pila: " + pi.desapilar()); // 20
        
        // Comprobamos si sigue teniendo algo
        if (!pi.estaVacia()) {
            System.out.println("Todavía queda el: " + pi.desapilar()); // 10
        }
    }
}
