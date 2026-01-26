package Progtema5;

class CuentaCorriente_profesor {
    String titular, codigo;
    double saldo;

    public CuentaCorriente_profesor(String titular, double saldo, String codigo) {
        this.titular = titular;
        this.saldo = saldo;
        if (codigo.length() == 8 && codigo.matches("[0-9]+")) {
            this.codigo = codigo;
        } else {
            this.codigo = "00000000";
        }
    }

    public void IngresarDinero(double cantidad) {
        this.saldo += cantidad;
        System.out.println("Saldo actualizado: " + this.saldo);
    }

    public void RetirarDinero(double cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            System.out.println("Saldo actualizado: " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}