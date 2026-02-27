package Progtema7;

public class Progtema7_1_objeto {
public static void main(String[] args) {
        empleados[] empresa = new empleados[100];
        empresa[0]= new empleados("juan ",1200);
        empresa[1]= new jefe("hugo",1400, "ingeniero de pocket pussy", "sex" );

        empresa[1].mostrarDetalles();
        empresa[0].mostrarDetalles();
    }
}