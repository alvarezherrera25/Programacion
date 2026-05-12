package Ejercicios_Finales.segund_evaluacion.ejercicio_8;

public class Revista {
    private String isbn;
    private String titulo;
    private int añoPublicacion;
    private int numero;

    public Revista(String isbn, String titulo, int añoPublicacion, int numero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
        this.numero = numero;
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

    public int getNumero() {
        return numero;
    }
}
