package Progtema5;
import java.util.Scanner;

public class Progtema5_2_objeto {
    
    public static void main(String[] args){
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();

        leerDatos(empleado1);
        verDatos(empleado1);
    }

    public static void leerDatos(Empleado empleado1,Empleado empleado2) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introducir nombre: ");
        String nombre1 = sc.nextLine();
        empleado1.setnombre(nombre1);

        System.out.println("Introducir numero de empleado: ");
        int numero_empleado1 = sc.nextInt();
        empleado1.setnumero_empleado(numero_empleado1);

        System.out.println("Introducir nombre: ");
        String nombre2 = sc.nextLine();
        empleado2.setnombre(nombre2);

        System.out.println("Introducir numero de empleado: ");
        int numero_empleado2 = sc.nextInt();
        empleado2.setnumero_empleado(numero_empleado2);

    }

    public static void verDatos(Empleado empleado1,Empleado empleado2) {

        System.out.println("He comprado el disco: " + empleado1.getnombre());
        System.out.println(empleado1.verDatos());

        System.out.println("");

        System.out.println("He comprado el disco: " + empleado2.getnombre());
        System.out.println(empleado2.verDatos());
    }
}