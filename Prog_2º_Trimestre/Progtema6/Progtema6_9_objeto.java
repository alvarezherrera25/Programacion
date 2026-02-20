public class Progtema6_9_objeto {
    public static void main(String[] args) {
        // Creamos la "colección" (el gestor)
        GestorRestaurante local = new GestorRestaurante();
        
        // Insertamos los platos (como tus discos)
        local.insertarPlato(new Plato("Gazpacho", "Tomate, pepino", 5.0));
        local.insertarPlato(new Plato("Ensalada", "Lechuga, atún", 4.5));
        local.insertarPlato(new Plato("Pollo asado", "Pollo, patatas", 8.0));
        local.insertarPlato(new Plato("Lasaña", "Carne, pasta", 9.0));
        local.insertarPlato(new Plato("Merluza", "Pescado, limón", 11.0));
        local.insertarPlato(new Plato("Entrecot", "Ternera a la brasa", 14.0));

        System.out.println("--- CARTA DEL DÍA ---");
        local.listarCarta();
        System.out.println();

        // Simulamos que una mesa pide 3 menús combinando los platos de la carta
        System.out.println("--- ANOTANDO MENÚS ---");
        // Piden Gazpacho (0) y Lasaña (3)
        local.insertarMenu(new Menu(local.carta[0], local.carta[3])); 
        // Piden Ensalada (1) y Entrecot (5)
        local.insertarMenu(new Menu(local.carta[1], local.carta[5])); 
        // Piden Gazpacho (0) y Merluza (4)
        local.insertarMenu(new Menu(local.carta[0], local.carta[4]));

        System.out.println("Menús anotados correctamente.\n");

        // A la hora de pagar, le pasamos cuánto dinero entregan (ej: 60€)
        local.cobrar(60.0);
    }
}