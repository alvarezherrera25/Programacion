package Progtema5;

public class Progtema5_3_objeto {
    public static void main(String[] args){
        trabajador t1 = new trabajador(1, "Juan Perez", 'C', 'N', 2, 5);

        /* Trabajador 1 */
        System.out.println(t1.obtenerDatos());

        System.out.printf("Nómina a percibir: %.2f euros\n\n", t1.calcularNomina());

        System.out.println(">>> Modificando datos del trabajador");
        t1.setEstadoCivil('S');
        t1.setTurno('D');

        System.out.println(t1.obtenerDatos());
        

        System.out.printf("Nueva nómina a percibir: %.2f euros\n", t1.calcularNomina());


    }
}
    

