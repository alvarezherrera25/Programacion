package ejercicios_notebook.tema_10.ejercicio_4;
/*
Utiliza las operaciones agregadas para procesar una lista de números enteros.
Crea una List<Integer> con los números: 10, 25, 8, 30, 42, 15, 7, 50.
Crea un Stream Pipeline para realizar las siguientes tareas en una sola instrucción:
Filtrar los números que sean mayores de 20 (filter).
Transformar los números restantes multiplicándolos por 2 (map).
Recolectar el resultado en una nueva lista (collect).
Calcula la suma de todos los elementos de la lista original usando la operación reduce.
Usa una referencia a método (System.out::println) para imprimir cada número de la nueva lista

*/
import java.util.*;
public class Main {
   public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 25, 8, 30, 42, 15, 7, 50);
        List<Integer> resultado = numeros.stream()
                .filter(n -> n > 20)
                .map(n -> n * 2)
                .toList();
                int suma = numeros.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Números mayores de 20 multiplicados por 2:");
         for ( Integer numero : resultado) {
            System.out.println(numero);
        }
        System.out.println("Suma de todos los elementos de la lista original: " + suma);
   }
}
