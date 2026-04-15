package ejercicios_gemini_practicar;

/*public class assert_except {
    private double precio = 50.0;

    public void aplicarDescuento(double porcentaje) {
        double precioAnterior = this.precio;

        // 1. Escribe aquí tu validación con Excepción (throw new...)
        if (porcentaje < 0 || porcentaje > 100){
            throw new IllegalArgumentException("Error: El porcentaje tiene que estar entre 0-100");
        }
        
        // 2. Escribe aquí la operación matemática para cambiar 'this.precio'
        this.precio = this.precio - (this.precio * (porcentaje / 100.0));
        
        // 3. Escribe aquí tu aserción (assert) comprobando el resultado
        assert this.precio < precioAnterior : "Error: El precio anterior no puede ser mayor";

        System.out.println("El precio final con descuento es: " + this.precio);
    }

}*/

 public class assert_except_catch {
    private double precio = 50.0;

    public void aplicarDescuento(double porcentaje) {
        double precioAnterior = this.precio;

        // 1. EXCEPCIÓN: Protegemos contra datos inválidos del usuario
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Error: El porcentaje tiene que estar entre 0 y 100");
        }
        
        // 2. LÓGICA DE NEGOCIO: Hacemos la matemática
        this.precio = this.precio + (this.precio * (porcentaje / 100.0));
        
        // 3. ASERCIÓN: Protegemos contra nuestros propios fallos matemáticos
        assert this.precio < precioAnterior : "Fallo Interno: El precio final no puede ser mayor o igual";

        System.out.println("El precio final con descuento es: " + this.precio + " €");
    }
    public static void main(String[] args) {
    assert_except_catch producto = new assert_except_catch();

    System.out.println("--- INTENTANDO UN DESCUENTO DEL 150% ---");
    
    // INTENTAMOS hacer algo peligroso
    try {
        producto.aplicarDescuento(150); 
        // Si la línea de arriba falla, el programa salta INMEDIATAMENTE al catch.
        System.out.println("Esta línea nunca se va a imprimir porque antes hubo un error.");
        
    } // CAPTURAMOS la excepción específica que sabíamos que podía saltar
    catch (IllegalArgumentException e) {
        
        // Aquí "desactivamos la bomba". El programa ya no se cierra (no sale letras rojas feas).
        // En su lugar, mostramos un mensaje amigable.
        // e.getMessage() recupera el texto que tú escribiste en el throw.
        System.out.println("Mensaje para el usuario: " + e.getMessage());
        System.out.println("Por favor, inténtelo de nuevo con un valor válido.");
    }
    
    System.out.println("\nEl programa sigue funcionando tranquilamente gracias al catch.");
}
}

  /*   // --- EL MOTOR DE PRUEBA ---
    public static void main(String[] args) {
        assert_except producto = new assert_except();

        System.out.println("--- PRUEBA 1: Funcionamiento normal ---");
        System.out.println("Intentando aplicar un 20% de descuento...");
        producto.aplicarDescuento(20); // Debería funcionar y dar 40.0 €
        
        
        System.out.println("\n--- PRUEBA 2: Probando la Excepción ---");
        // QUITA LAS BARRAS '//' DE LA LÍNEA DE ABAJO PARA PROBAR LA EXCEPCIÓN
        // producto.aplicarDescuento(150); 
        
        
        System.out.println("\n--- PRUEBA 3: Probando la Aserción ---");
        // Para que la aserción salte, el programador tiene que haberse equivocado.
        // Ve arriba a la "Lógica de negocio" y cambia el signo '-' por un '+'.
        // Luego ejecuta el programa asegurándote de tener activado el comando -ea.
    }
}*/

