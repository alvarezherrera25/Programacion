
public class Progtema6_7_objeto {
    
    public static void main(String[] args) {
        // 1. Creamos el vector para 50 empleados
        Empleado[] lista = new Empleado[50];
        String[] nombres = {"Carlos", "Sonia", "Raúl", "Beatriz", "Jorge", "Alicia"};

        // 2. Rellenamos el vector
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new Empleado();
            
            int nomAleatorio = (int) (Math.random() * nombres.length);
            lista[i].setnombre(nombres[nomAleatorio]);
            
            lista[i].setnumero_empleado(i + 1);
        }

        // 3. Mostramos los resultados
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i].verDatos());
        }
    }
}