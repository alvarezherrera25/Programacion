package ejercicio_3_clasica;

public class Alumno {
    int id;
    String nombre;
    String apellido;
    int nota1, nota2, nota3;
    double notaMedia;

    public Alumno(int id, String nombre, String apellido, int nota1, int nota2, int nota3) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaMedia = (nota1 + nota2 + nota3) / 3.0;
    }

    @Override
    public String toString() {
        return String.format("ID: %02d | %-10s %-10s | Media: %.2f", 
                id, apellido + ",", nombre, notaMedia);
    }
}
