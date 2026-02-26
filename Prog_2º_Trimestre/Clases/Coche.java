package Clases;

// --- PARTE 1: El Molde (Coche) ---
public class Coche {
    // Atributos (estado del objeto)
    private String marca;
    private String modelo;
    private int numero_serie;

    // Constructor (la fábrica)
    public Coche(String marca, String modelo, int numero_serie) {
        this.marca = marca;
        this.modelo = modelo;
        this.numero_serie = numero_serie;
    }

    // Métodos Get (para leer datos de forma segura)
    public String getMarca() {
        return marca;
    }

    // Método de acción (comportamiento)
    public void arrancar() {
        System.out.println("El " + marca + " " + modelo + " ha arrancado. ¡Brum brum!");
    }
}

