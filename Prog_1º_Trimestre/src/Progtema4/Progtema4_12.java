/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

public class Progtema4_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Paso 1: Leer palabra
        System.out.print("Introduce palabra (<=20): ");
        String palabra = sc.nextLine();

        // Paso 2: Validar
        if (palabra.length() == 0) {
            System.out.println("Palabra vacía");
        } else if (palabra.length() > 20) {
            System.out.println("No pueden ser más de 20 caracteres");
        } else {
            // Paso 3: Imprimir rotaciones
            System.out.println("Imprimiendo rotaciones de: " + palabra);
            for (int i = 0; i < palabra.length(); i++) {
                String rotated = palabra.substring(i) + palabra.substring(0, i);
                System.out.println(rotated);
            }
        }
    }
}