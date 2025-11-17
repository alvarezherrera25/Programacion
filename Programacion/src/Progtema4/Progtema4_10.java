/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
// Sin expresiones regulares: usamos comprobaciones sencillas con substring y Character

/**
 * Programa que valida códigos de personas y genera un informe.
 * Valida: 4 dígitos de año (1990-1995), sexo (H/M), curso (1/2), 2 caracteres libres.
 * Finaliza con "00000000" y muestra estadísticas de matriculación.
 * @author alvarezherrera25
 */
public class Progtema4_10 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        int totalCodigos = 0;
        int mujeresPrimero = 0;
        int mujeresSegundo = 0;
        int hombresPrimero = 0;
        int hombresSegundo = 0;
        String codigo;
        char sexo;
        char curso;

        do {
            System.out.print("Introduce tu codigo de 8 numeros: ");
            codigo = sc.nextLine().toUpperCase();
            if (codigo.length() != 8) {
                System.out.println("Error, vuelve a intentarlo");
                System.out.print("Introduce tu codigo de 8 numeros: ");
            } else {

                String anioSt = codigo.substring(0, 4);
                int anio = Integer.parseInt(anioSt);
                if ((anio >= 1990) && (anio <= 1995)) {

                    curso = codigo.charAt(5);
                    sexo = codigo.charAt(4);
                    if (sexo == 'M') {
                        if (curso == '1') {
                            mujeresPrimero++;
                            totalCodigos++;
                        } else if (curso == '2') {
                            mujeresSegundo++;
                            totalCodigos++;
                        } else {
                             System.out.println("Error, tiene q ser curso 1 o 2");
                        }

                    } else if (sexo == 'H') {
                        if (curso == '1') {
                            hombresPrimero++;
                            totalCodigos++;
                        } else if (curso == '2') {
                            hombresSegundo++;
                            totalCodigos++;

                        } else {
                            System.out.println("Error, tiene q ser curso 1 o 2");

                        }
                    }else {
                         System.out.println("Seño incorrecto");
                    }
                }else {
                     System.out.println("Error, año fuera de rango");
                }
            }
        } while (!codigo.equals("00000000"));
 System.out.println("\n--- INFORME FINAL ---");
        System.out.println("Mujeres en primero: " + mujeresPrimero);
        System.out.println("Hombres en primero: " + hombresPrimero);
        System.out.println("Mujeres en segundo: " + mujeresSegundo);
        System.out.println("Hombres en segundo: " + hombresSegundo);
        System.out.println("Codigos introducidos: " + totalCodigos);
    }
}