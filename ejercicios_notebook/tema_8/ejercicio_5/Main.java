package ejercicios_notebook.tema_8.ejercicio_5;
/*
Aplica lo aprendido en un simulador de almacén.
Crea una clase Producto con un atributo stock.
Crea un método retirarStock(int cantidad):
Capa de Validación (Excepción): Si la cantidad a retirar es negativa, lanza IllegalArgumentException.
Lógica de Negocio: Resta la cantidad al stock.
Verificación de Integridad (Aserción): Usa un assert para comprobar que, después de la resta, el stock nunca ha quedado negativo. 
Si quedó negativo, es que tu lógica de control de stock previa falló.
*/
public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto(100);
        try {
            producto.retirarStock(50);
            producto.retirarStock(-10); // Esto lanzará una excepción
            producto.retirarStock(60); // Esto hará que el stock quede negativo, lo que activará la aserción
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
