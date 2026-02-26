import java.util.Scanner;

public class Comedor {
    
    // El máximo de menús al día es 100
    private static final int MAX_MENUS = 100;
    private static int menusServidos = 0;
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Crear la carta con 6 platos (mostrando ingredientes y precio)
        Plato[] carta = new Plato[6];
        carta[0] = new Plato("Macarrones a la boloñesa", "Pasta, carne picada, tomate, cebolla", 6.50);
        carta[1] = new Plato("Ensalada César", "Lechuga, pollo, picatostes, salsa César, queso", 5.00);
        carta[2] = new Plato("Sopa de marisco", "Caldo de pescado, gambas, mejillones, fideos", 7.00);
        carta[3] = new Plato("Entrecot de ternera", "Carne de ternera, patatas, pimientos de padrón", 12.50);
        carta[4] = new Plato("Salmón al horno", "Salmón, limón, eneldo, espárragos", 11.00);
        carta[5] = new Plato("Pollo asado con patatas", "Medio pollo, especias, patatas panadera", 8.50);

        System.out.println("¡Bienvenido al Restaurante!");

        // 2. Bucle para atender clientes durante el día
        while (menusServidos < MAX_MENUS) {
            System.out.println("\n-------------------------------------------------");
            System.out.println("Menús disponibles hoy: " + (MAX_MENUS - menusServidos));
            System.out.print("¿Cuántos menús quiere la mesa? (0 para cerrar caja): ");
            int cantidadPedidos = teclado.nextInt();
            
            // Si ponen 0, cerramos el restaurante
            if (cantidadPedidos == 0) {
                break; 
            }

            // Comprobar que no pidan más menús de los que quedan
            if (cantidadPedidos < 0 || cantidadPedidos > (MAX_MENUS - menusServidos)) {
                System.out.println("Error. Solo nos quedan " + (MAX_MENUS - menusServidos) + " menús.");
                continue; // Vuelve a preguntar
            }

            // Atender a la mesa actual
            Menu[] pedidoMesa = new Menu[cantidadPedidos];

            // Mostrar la carta
            System.out.println("\n--- CARTA DEL RESTAURANTE ---");
            for (int i = 0; i < carta.length; i++) {
                System.out.println((i + 1) + ". " + carta[i].getNombre() + " (" + carta[i].getPrecio() + "€)");
                System.out.println("   Ingredientes: " + carta[i].getIngredientes());
            }
            System.out.println("-----------------------------");

            // Tomar nota de cada menú
            for (int i = 0; i < cantidadPedidos; i++) {
                System.out.println("\nConfigurando Menú " + (i + 1) + " de " + cantidadPedidos + ":");
                
                System.out.print("Elija el número del primer plato (1-6): ");
                int opcion1 = leerOpcionPlato();
                
                System.out.print("Elija el número del segundo plato (1-6): ");
                int opcion2 = leerOpcionPlato();

                // Guardar el menú (restando 1 porque los arrays empiezan en 0)
                pedidoMesa[i] = new Menu(carta[opcion1 - 1], carta[opcion2 - 1]);
                menusServidos++;
            }

            // Imprimir el ticket y cobrar a la mesa
            cobrarMesa(pedidoMesa);
        }
        
        System.out.println("\nCierre del restaurante. Total de menús servidos hoy: " + menusServidos);
        teclado.close();
    }

    // --- MÉTODOS AUXILIARES DE LA CLASE COMEDOR ---

    // Método para asegurar que el cliente elige un plato del 1 al 6
    private static int leerOpcionPlato() {
        int opcion = teclado.nextInt();
        while (opcion < 1 || opcion > 6) {
            System.out.print("Opción no válida. Elija un plato del 1 al 6: ");
            opcion = teclado.nextInt();
        }
        return opcion;
    }

    // Método para calcular, mostrar el ticket, pedir dinero y dar cambio
    private static void cobrarMesa(Menu[] pedidoMesa) {
        System.out.println("\n========================================");
        System.out.println("           TICKET DE LA MESA            ");
        System.out.println("========================================");
        
        double totalAPagar = 0;

        for (int i = 0; i < pedidoMesa.length; i++) {
            Menu m = pedidoMesa[i];
            double precioMenu = m.getPrecioTotal();
            totalAPagar += precioMenu;
            
            System.out.println("MENÚ " + (i + 1) + " ........................ " + precioMenu + "€");
            System.out.println("  - Plato 1: " + m.getPrimerPlato().getNombre() + " (" + m.getPrimerPlato().getPrecio() + "€)");
            System.out.println("  - Plato 2: " + m.getSegundoPlato().getNombre() + " (" + m.getSegundoPlato().getPrecio() + "€)");
            System.out.println("  - Bebida y postre ............. (Invita la casa: 0.00€)");
        }
        
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL A PAGAR: %.2f€\n", totalAPagar);
        System.out.println("========================================");

        // Pedir el dinero y calcular el cambio
        double dineroEntregado;
        do {
            System.out.print("Introduzca el dinero entregado por el cliente: ");
            dineroEntregado = teclado.nextDouble();
            if (dineroEntregado < totalAPagar) {
                System.out.printf("Dinero insuficiente. Faltan %.2f€\n", (totalAPagar - dineroEntregado));
            }
        } while (dineroEntregado < totalAPagar);

        double cambio = dineroEntregado - totalAPagar;
        System.out.printf("CAMBIO A DEVOLVER: %.2f€\n", cambio);
        System.out.println("¡Gracias por su visita!\n");
    }
}

// =========================================================================
// CLASES DE APOYO (Plato y Menu)
// =========================================================================

class Plato {
    private String nombre;
    private String ingredientes;
    private double precio;

    public Plato(String nombre, String ingredientes, double precio) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public double getPrecio() {
        return precio;
    }
}

class Menu {
    private Plato primerPlato;
    private Plato segundoPlato;

    public Menu(Plato primerPlato, Plato segundoPlato) {
        this.primerPlato = primerPlato;
        this.segundoPlato = segundoPlato;
    }

    public Plato getPrimerPlato() {
        return primerPlato;
    }

    
    public Plato getSegundoPlato() {
        return segundoPlato;
    }

    // El precio del menú es la suma de los dos platos
    public double getPrecioTotal() {
        return primerPlato.getPrecio() + segundoPlato.getPrecio();
    }
}