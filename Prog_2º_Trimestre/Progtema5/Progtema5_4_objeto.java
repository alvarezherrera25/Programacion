package Progtema5;

public class Progtema5_4_objeto{
    public static void main(String[] args) {
        // 1. Crear el objeto 
        CuentaCorriente miCuenta = new CuentaCorriente("Juan Pérez", 1000.0, "12345678");

        System.out.println("Titular: " + miCuenta.getTitular());
        System.out.println("Saldo Inicial: " + miCuenta.getSaldo());
        System.out.println("--------------------------------");

        // 2. Probar IngresarDinero
        miCuenta.IngresarDinero(500.0); 

        // 3. Probar RetiraDinero (Caso posible)
        miCuenta.RetirarDinero(200.0);

        // 4. Probar RetiraDinero (Caso imposible)
        miCuenta.RetirarDinero(5000.0);
    }
}
