package Progtema5;

import java.util.Scanner;

public class Progtema5_4_objeto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CuentaCorriente c1 = new CuentaCorriente("Ana", 1000.0, "12345678");
        CuentaCorriente c2 = new CuentaCorriente("Luis", 500.0, "87654321");

        System.out.println("Cambiando el código de la cuenta de Luis...");
        String codigoPropuesto = "12345678"; 

        if (codigoPropuesto.equals(c1.codigo)) {
            System.out.println("ERROR: No se puede cambiar el código. El código " + codigoPropuesto + " ya pertenece a la cuenta de " + c1.titular);
        } else {
            c2.codigo = codigoPropuesto;
            System.out.println("Código actualizado con éxito.");
        }

        System.out.print("\nIngrese el código de la cuenta a la que desea entrar: ");
        String login = sc.nextLine();

        if (login.equals(c1.codigo)) {
            System.out.println("Bienvenida, Ana. Tu saldo es: " + c1.saldo);
        } else if (login.equals(c2.codigo)) {
            System.out.println("Bienvenido, Luis. Tu saldo es: " + c2.saldo);
        } else {
            System.out.println("Acceso denegado: Código no encontrado.");
        }
    }
}