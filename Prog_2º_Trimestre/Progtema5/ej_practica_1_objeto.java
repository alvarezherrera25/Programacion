package Progtema5;

import java.util.Scanner;

public class ej_practica_1_objeto{
    public static void main (String[] args){
        galeria galeria1 = new galeria();

        leerDatos(galeria1);
        verDatos(galeria1);
    }

    public static void leerDatos(galeria galeria1){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introducir nombre: ");
        String nombre1 = sc.nextLine();
        galeria1.setNombre(nombre1);

        System.out.print("Introducir fecha: ");
        int fecha1 = sc.nextInt();
        galeria1.setFecha(fecha1);

        System.out.print("Introducir cantidad");
        int cantidad1 = sc.nextInt();
        galeria1.setCantidad(cantidad1);
    }

    public static void verDatos(galeria galeria1){
        System.out.println("--- Datos galeria 1 ---");
        System.out.println("Nombre: " + galeria1.getNombre());
        System.out.println(galeria1.verDatos());
    }
}