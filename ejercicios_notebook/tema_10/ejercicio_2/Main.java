package ejercicios_notebook.tema_10.ejercicio_2;
/*
Implementa un pequeño sistema de inventario donde cada producto tiene un código único.
Usa un HashMap<String, Integer> donde la clave (K) sea el código del producto y el valor (V) sea la cantidad en stock.
Inserta al menos 5 productos usando el método put(K, V).
Implementa una función que reciba un código y devuelva si el producto existe (containsKey) y cuántas unidades hay (get).
Recorre el mapa utilizando entrySet() para mostrar cada código con su cantidad correspondiente
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("P001", 50);
        inventario.put("P002", 30);
        inventario.put("P003", 20);
        inventario.put("P004", 10);
        inventario.put("P005", 5);

        String codigo = "P003";
        if ( inventario.containsKey(codigo)) {
            System.out.println("El producto " + codigo + " existe en el inventario.");
            System.out.println("Cantidad en stock: " + inventario.get(codigo));
        } else {
            System.out.println("El producto " + codigo + " no existe en el inventario.");
        }
    }
}
