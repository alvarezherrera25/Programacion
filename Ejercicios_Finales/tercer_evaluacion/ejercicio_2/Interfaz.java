package Ejercicios_Finales.tercer_evaluacion.ejercicio_2;
import java.util.*;
public class Interfaz {
    Scanner sc = new Scanner(System.in);
    //Menu
    public void crearViajante() {
        //solicitar datos del viajante
        System.out.println("DNI: ");
        String dni = sc.nextLine();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Antiguedad: ");
        int antiguedad = sc.nextInt();
        System.out.println("Km: ");
        int km = sc.nextInt();


        Viajante nuevo = new Viajante(dni, nombre, antiguedad, km);
    }
}
