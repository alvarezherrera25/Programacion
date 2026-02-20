public class Progtema6_8_objeto {
   public static void main(String[] args) {
        
        // AQUÍ SE CREA EL OBJETO DE LA CLASE CUENTAS
        Cuentas misCuentas = new Cuentas(); 

        // Usamos el objeto para ejecutar la lógica
        misCuentas.cargarDatos();       // El objeto carga sus 100 cuentas
        misCuentas.mostrarMayorSaldo(); // El objeto calcula y muestra el ganador
    }
}