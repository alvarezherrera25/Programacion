package ejercicios_notebook.tema_10.ejercicio_3;
/*
Vamos a trabajar con objetos complejos y su ordenación.
Crea una clase Pelicula con atributos titulo (String) y año (int).
Crea una List<Pelicula> de tipo ArrayList y añade varias películas desordenadas.
Ordena la lista por año de estreno de forma ascendente. Para ello, usa el método lista.sort() pasando una expresión lambda como comparador: (p1, p2) -> p1.getAño() - p2.getAño().
Muestra la lista antes y después de ordenar para comprobar el resultado.
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("El Padrino", 1972));
        peliculas.add(new Pelicula("Pulp Fiction", 1994));
        peliculas.add(new Pelicula("La Lista de Schindler", 1993));
        peliculas.add(new Pelicula("Forrest Gump", 1994));
        peliculas.add(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 2001));
        System.out.println("Películas antes de ordenar:");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
        peliculas.sort((p1, p2) -> p1.getAño() - p2.getAño());
        System.out.println("\nPelículas después de ordenar por año:");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.toString());
        }
    }
}
