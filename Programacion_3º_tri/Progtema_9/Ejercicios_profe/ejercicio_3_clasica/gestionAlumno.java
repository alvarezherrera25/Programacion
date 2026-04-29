package ejercicio_3_clasica;

import java.util.*; // Trae todo lo necesario para usar ArrayList, Collections, etc.

public class gestionAlumno {
    public static void main(String[] args) {
        
        // Datos para generar aleatorios
        String[] nombres = {"Ana", "Luis", "Carlos", "Marta", "Elena", "Jorge", "Lucía", "Mario", "Sara", "David"};
        String[] apellidos = {"García", "López", "Pérez", "González", "Sánchez", "Martínez", "Rodríguez", "Fernández", "Gómez", "Martín"};

        List<Alumno> lista = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            String nom = nombres[(int) (Math.random() * 10)];
            String ape = apellidos[(int) (Math.random() * 10)];
            int nota1 = (int) (Math.random() * 101);
            int nota2 = (int) (Math.random() * 101);
            int nota3 = (int) (Math.random() * 101);
            
            lista.add(new Alumno(i, nom, ape, nota1, nota2, nota3));
        }

        System.out.println(" --- Lista de Alumnos orden alfabético ---");
        lista.sort(new ComparadorPorNombre());
        for (Alumno a : lista) {
            System.out.println(a.toString());
        }

        System.out.println(" --- Lista de Alumnos orden por nota media ---");
        lista.sort(new ComparadorPorNota());
        for (Alumno a : lista) {
            System.out.println(a.toString());
        }
    }
}
