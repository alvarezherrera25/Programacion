package ejercicios_notebook.tema_8.ejercicio_5;

public class Producto {
    private int stock;

    public Producto(int stock) {
        this.stock = stock;
    }

    public void retirarStock(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a retirar no puede ser negativa.");
        }
        stock -= cantidad;
        assert stock >= 0 : "El stock no puede ser negativo.";
    }
}
