package Programacion_3º_tri.Progtema_8.ejercicio_1;


import java.util.Scanner;

public class galeria_tema_5_objeto {
    public static void main(String[] args) {
        try {
            galeria galeria1 = new galeria("Museo del Prado", 0, 150.5);
            verDatos(galeria1);
            
        } catch (IllegalArgumentException e) {
            System.out.println("¡Ups! Dato incorrecto: " + e.getMessage());
        }
    }

    public static void verDatos(galeria galeria1) {
        System.out.println("--- Datos galeria 1 ---");
        System.out.println("Nombre: " + galeria1.getNombre());
        System.out.println(galeria1.verDatos());
    }
}