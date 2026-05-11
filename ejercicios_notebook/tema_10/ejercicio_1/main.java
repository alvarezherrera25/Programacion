package ejercicios_notebook.tema_10.ejercicio_1;
/*
Crea un programa para gestionar la lista de invitados a un evento.
Usa un HashSet para almacenar los nombres de los invitados. Recuerda que esta colección no admite elementos duplicados.
Añade varios nombres, incluyendo algunos repetidos para verificar que el Set los ignora automáticamente.
Usa un bucle for-each para mostrar la lista final por pantalla.
Bonus: Cambia la implementación a un TreeSet y observa cómo los nombres aparecen ahora ordenados alfabéticamente (orden natural)
*/
import java.util.*;
public class main {
    public static void main(String[] args) {
        Set<String> invitados = new TreeSet<> (); // Usamos TreeSet para mantener los nombres ordenados y ademas sin duplicados
        invitados.add("Ana");
        invitados.add("Luis");
        invitados.add("Carlos");
        invitados.add("Ana");

        System.out.println("Lista de invitados (TreeSet):");
        for ( String invitado : invitados) {
            System.out.println(invitado);
        }
    } 
}
