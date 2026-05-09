package ejercicios_notebook.tema_9.ejercicio_2;


public class Main {
    public static void main(String[] args) { 
        
        // Instanciación usando el operador diamante <> [14, 15]
        // Declaramos que esta pila solo trabajará con objetos String [4, 14]
        Pila<String> nombres = new Pila<>(); 

        // Usamos los métodos definidos en la otra clase
        System.out.println("¿Está vacía? " + nombres.vacia()); // true [9]
        
        nombres.apilar("Adolfo"); // El último en entrar es el primero en salir (LIFO) [16, 17]
        nombres.apilar("Felipe");
        nombres.apilar("Pedro");

        // Desapilamos para ver el orden LIFO
        System.out.println("Elemento retirado: " + nombres.desapilar()); // Pedro [16]
        System.out.println("¿Está vacía ahora? " + nombres.vacia()); // false [9]
        
        // También podemos crear una pila de enteros usando la clase envolvente [4, 18]
        Pila<Integer> numeros = new Pila<>();
        numeros.apilar(100);
        System.out.println("Valor numérico desapilado: " + numeros.desapilar()); // 100 [9]
    }
}