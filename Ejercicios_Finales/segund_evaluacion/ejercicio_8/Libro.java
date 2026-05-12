package Ejercicios_Finales.segund_evaluacion.ejercicio_8;

public class Libro {
    private String isbn;
    private String titulo;
    private int añoPublicacion;
    private boolean prestado;

    public Libro(String isbn, String titulo, int añoPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
        this.prestado = false; // Al crear un libro, no está prestado
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void presta() {
        if (!prestado) {
            prestado = true; // El libro se presta
        }
    }

    public void devuelve() {
        if (prestado) {
            prestado = false; // El libro se devuelve
        }
    }
}
