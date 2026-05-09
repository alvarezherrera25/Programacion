package ejercicios_notebook.tema_8.ejercicio_3;
/*
Vamos a aplicar el principio de "Falla Rápido" (Fail-Fast).
Crea un método llamado aplicarDescuento(double precioOriginal, double porcentaje).
Dentro del método, usa una aserción para verificar que el descuento nunca sea mayor al 100% ni menor al 0%.
Sintaxis sugerida: assert porcentaje <= 100 : "Error lógico: Descuento imposible";
Calcula el precio final y devuélvelo.
Práctica importante: Recuerda que para que este ejercicio falle visualmente
si pones un descuento de 200%, debes ejecutar Java con la opción -ea (enableassertions)

 */
public class Main {
    public static void main(String[] args) {
        try {
            double precioOriginal = 100.0;
            double porcentajeDescuento = 150.0;
            double precioFinal = aplicarDescuento(precioOriginal, porcentajeDescuento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static double aplicarDescuento(double precioOriginal, double porcentaje) {
        assert porcentaje <= 100 : "Error logico: Descuento imposible";
        assert porcentaje >= 0 : "Error logico: Descuento imposible";
        double precioFinal = precioOriginal - (precioOriginal * (porcentaje / 100));
        System.out.println("Precio final: " + precioFinal);
        return precioFinal;
    }
}
