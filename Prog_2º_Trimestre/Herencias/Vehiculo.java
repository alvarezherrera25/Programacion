package Herencias;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int numero_serie;

    public Vehiculo(String marca, String modelo, int numero_serie) {
        this.marca = marca;
        this.modelo = modelo;
        this.numero_serie=numero_serie;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getNumeroSerie() { return numero_serie; }
    public void mostrarDetalles() {
        System.out.println("Vehículo genérico: " + marca + " " + modelo);
    }
}


class Coche extends Vehiculo {
    private int numero_puertas;

    public Coche(String marca, String modelo,int numero_serie, int numero_puertas){
        super(marca, modelo, numero_serie);
        this.numero_puertas=numero_puertas;
    }

   @Override
    public void mostrarDetalles() {
        System.out.println(" | Coche: " + getMarca() + " " + getModelo() + 
                           " | Serie: " + getNumeroSerie() + 
                           " | Puertas: " + numero_puertas);
    }
}

class Moto extends Vehiculo{
    private boolean tiene_caballete;

    public Moto(String marca, String modelo,int numero_serie, boolean tiene_caballete){
        super(marca, modelo, numero_serie);
        this.tiene_caballete=tiene_caballete;
    }

    @Override
    public void mostrarDetalles() {
        String estadoCaballete = tiene_caballete ? "Sí" : "No";
        System.out.println(" | Moto: " + getMarca() + " " + getModelo() + 
                           " | Serie: " + getNumeroSerie() + 
                           " | ¿Tiene caballete?: " + estadoCaballete);
    }
}
