package ejercicio_3_landa;

import java.util.*;

public class gestionAlumno {
    public static void main(String[] args) {
        
        String[] nombres = {"Ana", "Luis", "Carlos", "Marta", "Elena", "Jorge", "Lucía", "Mario", "Sara", "David"};
        String[] apellidos = {"García", "López", "Pérez", "González", "Sánchez", "Martínez", "Rodríguez", "Fernández", "Gómez", "Martín"};

        List<Alumno> listaAlumnos = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            String nombreE = nombres[(int) (Math.random() * 10)];
            String apellidoE = apellidos[(int) (Math.random() * 10)];
            int n1 = (int) (Math.random() * 101); 
            int n2 = (int) (Math.random() * 101);
            int n3 = (int) (Math.random() * 101);
            
            listaAlumnos.add(new Alumno(i, nombreE, apellidoE, n1, n2, n3));
        }
        System.out.println(" --- Lista de Alumnos orden alfabético ---");

        listaAlumnos.sort((a1, a2) -> {
            int resultado = a1.apellido.compareTo(a2.apellido);
            if(resultado == 0) {
            resultado = a1.nombre.compareTo(a2.nombre);
            }
            return resultado;
        });
        listaAlumnos.forEach(al -> System.out.println(al.toString()));

        System.out.println(" --- Lista de Alumnos orden por nota media ---");
        listaAlumnos.sort((a1, a2) -> Double.compare(a2.notaMedia, a1.notaMedia));
        listaAlumnos.forEach(al -> System.out.println(al.toString()));
    }
}

