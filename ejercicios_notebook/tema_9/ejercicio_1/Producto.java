package ejercicios_notebook.tema_9.ejercicio_1;

public class Producto implements Ordenable {
    private int id;
    private String nombre;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public boolean menorQue(Ordenable otro) {
        // Hacemos casting para comparar los IDs [4]
        return this.id < ((Producto) otro).id;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " + nombre;
    }
}