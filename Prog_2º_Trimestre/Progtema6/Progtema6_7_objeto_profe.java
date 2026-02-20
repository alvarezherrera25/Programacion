public class Progtema6_7_objeto_profe {
    public static void main(String[] args) {
        
        Conjunto miConjunto = new Conjunto();
        
        System.out.println("--- Probando a agregar elementos ---");

        // Como usamos tu código original (void), no podemos guardarlo en un boolean.
        // Simplemente llamamos al método. Si hay error, tu código imprimirá el System.out.println.
        
        System.out.println("Intentando agregar el 5...");
        miConjunto.agregar(5); 

        System.out.println("Intentando agregar el 10...");
        miConjunto.agregar(10); 

        System.out.println("Intentando agregar el 5 de nuevo (debería dar error)...");
        miConjunto.agregar(5); 

        System.out.println("\n--- Vaciando el conjunto ---");
        miConjunto.vaciar();
        System.out.println("El conjunto ha sido vaciado.");

        System.out.println("Intentando agregar el 5 después de vaciar...");
        miConjunto.agregar(5);
        
        System.out.println("\n¡Fin de la prueba!");
    }
}