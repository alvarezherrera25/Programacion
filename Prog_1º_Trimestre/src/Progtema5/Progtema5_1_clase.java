package Progtema5;

class Disco {

    private String titulo;
    private int numeroCanciones;
    private double precio;
    private String fechaCompra;

    public Disco(String titulo, int numeroCanciones, double precio, String fechaCompra){
        this.titulo = titulo;
        this.numeroCanciones = numeroCanciones;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
    }
 
    public String getTitulo(){
        return titulo;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public String mostrarInfo() {
        return "Disco: " + titulo + " | Precio: " + precio + " | Fecha de compra: " + fechaCompra ;
    }
}