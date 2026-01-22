package Progtema5;

public class Progtema5_1_objeto {
    public static void main(String[] args) {
        
        Disco miDisco1 = new Disco("Bad Bunny", 12, 19.99, "20/01/2024");
        Disco miDisco2 = new Disco("Trueno", 1, 5, "02/01/2023");

        System.out.println("He comprado el disco: " + miDisco1.getTitulo());
        System.out.println(miDisco1.mostrarInfo());

        System.out.println("");

        System.out.println("He comprado el disco: " + miDisco2.getTitulo());
        System.out.println(miDisco2.mostrarInfo());
    }
}