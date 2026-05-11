package Ejercicios_Finales.primer_evaluacion.ejercicio_1;
/*
Hacer un programa que lea un número N y nos escriba en la pantalla, mediante un
mensaje, si es o no primo (NOTA: Número primo es aquél que es divisible solo por
sí mismo y por la unidad)
Desarrollar este programa creando un método llamado primo que devuelva true
si el número es primo y false si no lo es.
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        int numero = sc.nextInt();
        if (primo(numero)) {
            System.out.println("El numero " + numero + " es primo.");
        } else {
            System.out.println("El numero " + numero + " no es primo.");
        }
    }

    public static boolean primo(int numero) {
        if (numero <= 1) {
            return false;
        } else {
            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

    
