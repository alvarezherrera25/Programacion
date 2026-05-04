package ejercicio_3_compareTo;
import java.util.*; // Trae todo lo necesario para usar ArrayList, Collections, etc.

public class gestionAlumno {
    public static void main(String[] args) {
        String[] nombres = {"Ana", "Luis", "Carlos", "Marta", "Elena", "Jorge", "Lucía", "Mario", "Sara", "David"};
        String[] apellidos = {"García", "López", "Pérez", "González", "Sánchez", "Martínez", "Rodríguez", "Fernández", "Gómez", "Martín"};

        List<Alumno> listaAlumnos = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            int indiceNombre = (int) (Math.random() * nombres.length);
            int indiceApellido = (int) (Math.random() * apellidos.length);

            String nombreElegido = nombres[indiceNombre];
            String apellidoElegido = apellidos[indiceApellido];

            int nota1 = (int) (Math.random() * 101);
            int nota2 = (int) (Math.random() * 101);
            int nota3 = (int) (Math.random() * 101);

            listaAlumnos.add(new Alumno(i, nombreElegido, apellidoElegido, nota1, nota2, nota3));

        }

        System.out.println(" --- Lista de Alumnos orden alfabético ---");
        listaAlumnos.sort(Comparator.comparing((Alumno a) -> a.apellido) .thenComparing(a -> a.nombre));

        for (Alumno al: listaAlumnos) {
            System.out.println(al.toString());
        }

        System.out.println(" --- Lista de Alumnos orden por nota media ---");
        listaAlumnos.sort(Comparator.comparing((Alumno a) -> a.notaMedia).reversed());

        for (Alumno al: listaAlumnos) {
            System.out.println(al.toString());
        }
    } 
}
