package Progtema5;

class CuentaCorriente {

    private String titular;
    private double saldo;
    private String codigo;

    public CuentaCorriente(String titular, double saldo, String codigo) {
        this.titular = titular;
        this.saldo = saldo;
        this.codigo = codigo; 
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo.length() == 8 && codigo.matches("[0-9]+")) {
            this.codigo = codigo;
        } else {
            System.out.println("Error: El código debe tener 8 números. No se ha modificado.");
        }
    }


    public void IngresarDinero(double cantidad) {
        this.saldo += cantidad;
        System.out.println("Ingresado: " + cantidad );
    }

    public boolean PuedoSacar(double cantidad) {
        return this.saldo >= cantidad;
    }

    public void RetirarDinero(double cantidad) {
        if (PuedoSacar(cantidad)) {
            this.saldo -= cantidad;
            System.out.println("Retirado: " + cantidad );
        } else {
            System.out.println("Error: Saldo insuficiente.");
        }
    }
}