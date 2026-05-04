class Empleado {
    private String nombre;
    private int numero_empleado;

    public void setnombre(String nombre) { 
        this.nombre = nombre; }
        
    public void setnumero_empleado(int n) { 
        this.numero_empleado = n; }

    public String verDatos() {
        return "Empleado #" + numero_empleado + " | Nombre: " + nombre;
    }
}