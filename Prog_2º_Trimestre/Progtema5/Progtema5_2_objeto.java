package Progtema5;
import java.util.Scanner;

public class Progtema5_2_objeto {
    
    public static void main(String[] args){
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();

        leerDatos(empleado1, empleado2); 
        verDatos(empleado1, empleado2);
    }

    public static void leerDatos(Empleado empleado1, Empleado empleado2) {

        Scanner sc = new Scanner(System.in);

        // --- Empleado 1 ---
        System.out.println("Introducir nombre 1: ");
        String nombre1 = sc.nextLine();
        empleado1.setnombre(nombre1);

        System.out.println("Introducir numero de empleado 1: ");
        int numero_empleado1 = sc.nextInt();
        empleado1.setnumero_empleado(numero_empleado1);
        
        // 3. CORRECCIÓN IMPORTANTE: Limpiar el buffer
        sc.nextLine(); 

        // --- Empleado 2 ---
        System.out.println("Introducir nombre 2: ");
        String nombre2 = sc.nextLine();
        empleado2.setnombre(nombre2);

        System.out.println("Introducir numero de empleado 2: ");
        int numero_empleado2 = sc.nextInt();
        empleado2.setnumero_empleado(numero_empleado2);
        
        // No cerramos el Scanner aquí si vamos a usarlo en otros lados, 
        // pero como es el final de la lectura, está bien.
    }

    public static void verDatos(Empleado empleado1, Empleado empleado2) {
        
        // 4. CORRECCIÓN: Cambiado el texto "He comprado el disco" por algo con sentido
        System.out.println("--- Datos Empleado 1 ---");
        System.out.println("Nombre: " + empleado1.getnombre());
        System.out.println(empleado1.verDatos());

        System.out.println("");

        System.out.println("--- Datos Empleado 2 ---");
        System.out.println("Nombre: " + empleado2.getnombre());
        System.out.println(empleado2.verDatos());
    }
}