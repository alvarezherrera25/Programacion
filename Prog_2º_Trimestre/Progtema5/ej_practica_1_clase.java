package Progtema5;

class galeria{
    private String nombre;
    private int fecha;
    private double cantidad;

    public galeria() {
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getFecha(){
        return fecha;
    }
    public void setFecha(int fecha){
        this.fecha = fecha;
    }
    public double getCantidad(){
        return cantidad;
    }
    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }
    public String verDatos(){
        return "Nombre :" + nombre + " | Fecha: " + fecha + " | Cantidad: " + cantidad;
    }

}

