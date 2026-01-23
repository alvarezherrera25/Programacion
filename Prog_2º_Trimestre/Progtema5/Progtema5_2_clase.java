package Progtema5;

class Empleado {
    private String nombre;
    private int numero_empleado;

    public Empleado(){
    }   

    public String getnombre(){
        return nombre;
    }

    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    public int getnumero_empleado(){
        return numero_empleado;
    }

    public void setnumero_empleado(int numero_empleado){
        this.numero_empleado = numero_empleado;
    }

    public String verDatos(){
       return "Ficha completa -> Nombre: " + nombre + " | Numero: " + numero_empleado;
    }
}