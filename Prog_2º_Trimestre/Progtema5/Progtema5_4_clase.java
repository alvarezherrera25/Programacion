package Progtema5;

class CuentaCorriente {
    String titular, codigo;
    double saldo;

    public CuentaCorriente(String titular, double saldo, String codigo) {
        this.titular = titular;
        this.saldo = saldo;
        
        if (codigo.length() == 8 && codigo.matches("[0-9]+")) {
            this.codigo = codigo;
        } else {
            this.codigo = "00000000"; 
            System.out.println("Código inválido. Se ha asignado por defecto: 00000000");
        }
    }

    public void IngresarDinero(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Ingreso exitoso. Nuevo saldo: " + this.saldo);
        }
    }

    public boolean PuedoSacar(double cantidad) {
        return this.saldo >= cantidad;
    }

    public void RetirarDinero(double cantidad) {
        // Usamos el método PuedoSacar para validar la operación
        if (PuedoSacar(cantidad)) {
            this.saldo -= cantidad;
            System.out.println("Retirada exitosa. Nuevo saldo: " + this.saldo);
        } else {
            System.out.println("Operación fallida: Saldo insuficiente.");
        }
    }
}

