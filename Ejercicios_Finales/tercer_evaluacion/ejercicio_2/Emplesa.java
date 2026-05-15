package Ejercicios_Finales.tercer_evaluacion.ejercicio_2;
import java.util.*;

public class Emplesa {
    //Opcion 1
    List<Viajante> viajantes;
    List<Venta> ventas;

    private class Par {
        Viajante p;
        Venta v;
    }
    List<Par> datos;

    //Opcion 2
    Map<Viajante, List<Venta>> datos = new HashMap<>();

    //Opcion 3
    private class Dato {
        Viajante p;
        List<Venta> ventas;
    }
}
