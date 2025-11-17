package Progtema4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
/**
 * Programa que cuenta la frecuencia de cada letra en una frase.
 * Solicita una frase de máximo 60 caracteres y muestra cuántas veces
 * aparece cada letra del alfabeto (A-Z) en la frase.
 * @author alvarezherrera25
 */
public class Progtema4_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        

        do {
            System.out.print("Introduce una frase de maximo 60 caracteres:");
            frase = sc.nextLine();
            frase = frase.toUpperCase();
            if (frase.length() > 60) {
                System.out.println("Error: La frase tiene mas de 80 caracteres");
            }
        } while (frase.length() > 60);
        
        System.out.println("Frecuencia:");

        int contador = 0;

        for (int i = 0; i < 26; i++) {
            char letraActual = (char)('A' + i);  
            int frecuencia = 0;  
            
            for (int j = 0; j < frase.length(); j++) {
                if (frase.charAt(j) == letraActual) {
                    frecuencia++;
                }
            }
            
            if (frecuencia > 0) {
                System.out.println(letraActual + ": " + frecuencia);
                contador++;
            }
        }
        System.out.println("Hay " + contador + " letras distinta");
    }
}