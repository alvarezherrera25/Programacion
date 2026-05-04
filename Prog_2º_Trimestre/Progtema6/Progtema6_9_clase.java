class Plato {
    String nombre, ingredientes;
    double precio;

    Plato(String n, String i, double p) { 
        nombre = n; 
        ingredientes = i; 
        precio = p; 
    }
}

class Menu {
    Plato p1, p2;

    Menu(Plato a, Plato b) { 
        p1 = a; 
        p2 = b; 
    }

    double precio() { 
        return p1.precio + p2.precio; 
    }
}

class GestorRestaurante {
    Plato[] carta = new Plato[6];
    Menu[] pedidos = new Menu[100]; 
    
    int indicePlatos = 0;
    int indicePedidos = 0;

    // Insertar plato en la carta (como tu insertar Disco)
    void insertarPlato(Plato p) {
        if (indicePlatos < 6) {
            carta[indicePlatos] = p;
            indicePlatos++;
        }
    }

    // Insertar menú pedido
    void insertarMenu(Menu m) {
        if (indicePedidos < 100) {
            pedidos[indicePedidos] = m;
            indicePedidos++;
        }
    }

    // Listar carta
    void listarCarta() {
        for (int i = 0; i < indicePlatos; i++) {
            System.out.println((i + 1) + ": " + carta[i].nombre + " (" + carta[i].ingredientes + ") - " + carta[i].precio + "€");
        }
    }

    // Mostrar ticket y cobrar
    void cobrar(double dineroEntregado) {
        double total = 0;
        System.out.println("--- DETALLE DE LA CUENTA ---");
        
        for (int i = 0; i < indicePedidos; i++) {
            Menu m = pedidos[i];
            System.out.println("Menú " + (i + 1) + ":");
            System.out.println("  " + m.p1.nombre + " -> " + m.p1.precio );
            System.out.println("  " + m.p2.nombre + " -> " + m.p2.precio );
            System.out.println("  Bebida y postre -> 0.0 (Invita la casa)");
            System.out.println("  Precio del menú: " + m.precio() );
            total += m.precio();
        }
        
        System.out.println("TOTAL A PAGAR: " + total );
        System.out.println("Dinero entregado: " + dineroEntregado );
        System.out.println("Cambio: " + (dineroEntregado - total) );
    }
}