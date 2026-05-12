package Ejercicios_Finales.segund_evaluacion.ejercicio_8;
/*
Se quiere informatizar una biblioteca. Crea las clases Publicacion, Libro y Revista. Las clases
deben estar implementadas con la jerarquía correcta. Las características comunes de las
revistas y de los libros son el código ISBN, el título, y el año de publicación. Los libros tienen
además un atributo prestado. Cuando se crean los libros, no están prestados. Las revistas
tienen un número. La clase Libro debe implementar la interfaz Prestable que tiene los
métodos presta, devuelve y estaPrestado.
*/
public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("978-0-123456-78-9", "El Quijote", 1605);
        Revista revista1 = new Revista("1234-5678", "Revista de Ciencia", 2020, 5);
        Publicacion publicacion1 = new Publicacion("5678-1234", "Publicación General", 2018);

        System.out.println("Libro: " + libro1.getTitulo() + ", ISBN: " + libro1.getIsbn() + ", Año: " + libro1.getAñoPublicacion());
        System.out.println("Revista: " + revista1.getTitulo() + ", ISBN: " + revista1.getIsbn() + ", Año: " + revista1.getAñoPublicacion() + ", Número: " + revista1.getNumero());
        System.out.println("Publicación: " + publicacion1.getTitulo() + ", ISBN: " + publicacion1.getIsbn() + ", Año: " + publicacion1.getAñoPublicacion());

        libro1.presta();
        System.out.println("¿El libro está prestado? " + libro1.estaPrestado());
        libro1.devuelve();
        System.out.println("¿El libro está prestado? " + libro1.estaPrestado());
    }
}
