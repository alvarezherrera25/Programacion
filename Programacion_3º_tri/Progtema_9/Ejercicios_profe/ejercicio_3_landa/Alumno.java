package ejercicio_3_landa;
import java.util.*;

class Alumno {
    int id;
    String nombre;
    String apellido;
    int nota1, nota2, nota3;
    double notaMedia;

    public Alumno(int id, String nombre, String apellido, int n1, int n2, int n3) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
        this.notaMedia = (n1 + n2 + n3) / 3.0; 
    }

    @Override
    public String toString() {
        return String.format("ID: %02d | %-10s %-10s | Media: %.2f", 
                id, apellido + ",", nombre, notaMedia);
    }
}