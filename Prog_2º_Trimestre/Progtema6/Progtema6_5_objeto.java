public class Progtema6_5_objeto {
    public static void main(String[] args) {
        Coleccion col = new Coleccion();
        
        col.insertar(new Disco("The Dark Side of the Moon", "Pink Floyd"));
        col.insertar(new Disco("Back in Black", "AC/DC"));
        col.insertar(new Disco("Rumours", "Fleetwood Mac"));
        col.insertar(new Disco("Nevermind", "Nirvana"));
        col.insertar(new Disco("Discovery", "Daft Punk"));

        
        System.out.println("--- Antes de borrar ---");
        col.listar();

        col.eliminar(0);

        System.out.println("--- Despues de borrar ---");
        col.listar();
    }
}
