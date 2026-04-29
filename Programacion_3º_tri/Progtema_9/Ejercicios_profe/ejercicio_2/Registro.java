package ejercicio_2;

public class Registro implements Comparable<Registro> {
    String nombrePartido;
    double cociente;

    public Registro(String nombrePartido, double cociente) {
        this.nombrePartido = nombrePartido;
        this.cociente = cociente;
    }

    @Override
    public int compareTo(Registro otro) {
        return Double.compare( otro.cociente, this.cociente); 
    }
}
