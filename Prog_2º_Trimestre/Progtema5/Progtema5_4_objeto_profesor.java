package Progtema5;

import java.util.Scanner;

public class Progtema5_4_objeto_profesor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Creamos las cuentas
        CuentaCorriente_profesor c1 = new CuentaCorriente_profesor("Juan", 1000, "12345678");
        CuentaCorriente_profesor c2 = new CuentaCorriente_profesor("Maria", 2000, "87654321");

        System.out.print("Introduce tu codigo de 8 digitos: ");
        String clave = sc.nextLine();

        // 2. Comparamos
        if (clave.equals(c1.codigo)) {
            System.out.println("Titular: " + c1.titular + " | Saldo: " + c1.saldo);
            System.out.print("Cantidad a ingresar: ");
            double ing = sc.nextDouble();
            c1.IngresarDinero(ing);
            
            System.out.print("Cantidad a retirar: ");
            double ret = sc.nextDouble();
            c1.RetirarDinero(ret);
        } 
        else if (clave.equals(c2.codigo)) {
            System.out.println("Titular: " + c2.titular + " | Saldo: " + c2.saldo);
            System.out.print("Cantidad a ingresar: ");
            double ing = sc.nextDouble();
            c2.IngresarDinero(ing);
            
            System.out.print("Cantidad a retirar: ");
            double ret = sc.nextDouble();
            c2.RetirarDinero(ret);
        } 
        else {
            System.out.println("Acceso denegado.");
        }
        
    }
}