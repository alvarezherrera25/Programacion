package ejercicios_notebook.tema_10.ejercicio_3;

public class Pelicula {
    private String titulo;
    private int año;

    public Pelicula(String titulo, int año) {
        this.titulo = titulo;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return titulo + " (" + año + ")";
    }
}
