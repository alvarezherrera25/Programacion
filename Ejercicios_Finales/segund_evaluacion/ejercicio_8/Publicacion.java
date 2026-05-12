package Ejercicios_Finales.segund_evaluacion.ejercicio_8;

public class Publicacion {
    private String isbn;
    private String titulo;
    private int añoPublicacion;

    public Publicacion(String isbn, String titulo, int añoPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
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
}
