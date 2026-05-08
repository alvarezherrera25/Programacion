package ejercicios_notebook.tema_8.ejercicio_1;

import java.util.*;
/*
Crea un programa que pida al usuario dos números enteros por teclado y realice la división del primero entre el segundo.
 Debes capturar la excepción específica que ocurre cuando se intenta dividir por cero (ArithmeticException) y mostrar un mensaje amigable. 
 Además, utiliza un bloque finally para asegurar que el programa se despide del usuario, ocurra o no el error.
*/


public class error_matematico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        try { 
            System.out.print("Introduce el primer numero entero: ");
            int num1 = sc.nextInt();
            System.out.print("Introduce el segundo numero entero: ");
            int num2 = sc.nextInt();

            int resultado = num1 / num2;
            System.out.println("El resultado es: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir entre cero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduce un numero entero valido.");
        } finally {
            System.out.println("Adios");
        }
    }
}
