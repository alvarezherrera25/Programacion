package Herencias;

public class Vehiculo_Main {
    public static void main(String[] args) {
        Vehiculo[] concesionario = new Vehiculo[10];

        concesionario[0] = new Coche("Toyota", "Corolla", 12345, 5);
        concesionario[1] = new Moto("Honda", "CBR", 999, true);
        concesionario[2] = new Coche("Ford", "Mustang", 777, 3);
        
        for (int i = 0; i < concesionario.length; i++) {
            if (concesionario[i] != null) {
                concesionario[i].mostrarDetalles();
            }
        }
        
    }
}