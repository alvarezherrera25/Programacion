class CuentaCorriente {
    private String titular, codigo;
    private double saldo;

    public CuentaCorriente(String titular, String codigo, double saldo) {
        this.titular = titular;
        this.codigo = codigo;
        this.saldo = saldo;
    }
    public double getSaldo() { 
        return saldo; 
    }
    public String getDatos() { 
        return "Titular: " + titular + " | Código: " + codigo + " | Saldo: " + saldo; 
    }
}

class Cuentas {
    // Vector de 100 objetos (atributo de la clase)
    private CuentaCorriente[] vector = new CuentaCorriente[100];

    // Método para llenar el vector (Lógica de negocio)
    public void cargarDatos() {
        for (int i = 0; i < 100; i++) {
            // Crear 100 objetos CuentaCorriente dentro del objeto Cuentas
            vector[i] = new CuentaCorriente("Titular " + i, "COD-" + i, Math.random() * 10000);
        }
    }

    // Método que realiza el algoritmo pedido (Ordenar saldos y buscar mayor)
    public void mostrarMayorSaldo() {
        double[] saldos = new double[100];

        // 1. Llenar vector auxiliar
        for (int i = 0; i < 100; i++) saldos[i] = vector[i].getSaldo();

        // 2. Ordenar (Burbuja)
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 99; j++) {
                if (saldos[j] > saldos[j+1]) {
                    double temp = saldos[j]; 
                    saldos[j] = saldos[j+1]; 
                    saldos[j+1] = temp;
                }
            }
        }

        // 3. Obtener máximo y mostrar coincidencias
        double max = saldos[99];
        System.out.println("Saldo Máximo: " + max);
        
        for (int i = 0; i < 100; i++) {
            if (vector[i].getSaldo() == max) {
                System.out.println(vector[i].getDatos());
            }
        }
    }
}