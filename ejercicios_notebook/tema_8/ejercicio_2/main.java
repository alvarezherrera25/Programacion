package ejercicios_notebook.tema_8.ejercicio_2;
import java.util.*;
/*
 Imagina que estás programando un sistema para una discoteca.
Crea una clase llamada MenorDeEdadException que herede de Exception.
Crea una clase Validador con un método comprobarEdad(int edad) que:
Lance (throw) la excepción MenorDeEdadException si la edad es menor de 18.
Declare en su cabecera que puede lanzar dicha excepción usando throws.
En el main, llama al método dentro de un bloque try-catch y recupera el mensaje de error usando el método getMessage()
*/

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        
        try {
            int edad = sc.nextInt();
            comprobarEdad(edad);
        }catch (MenorDeEdadException e) {
            System.out.println(e.getMessage());
        }catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduce un numero entero valido.");
        }
    }
    public static void comprobarEdad(int edad) throws MenorDeEdadException {
        if (edad < 18) {
            throw new MenorDeEdadException("Error: No puedes entrar a la discoteca, eres menor de edad.");
        } else {
            System.out.println("Bienvenido a la discoteca!");
        }
    }
}

