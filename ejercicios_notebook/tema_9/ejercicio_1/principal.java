package ejercicios_notebook.tema_9.ejercicio_1;
/*
Crea una interfaz llamada Ordenable que contenga el método boolean menorQue(Ordenable otro).
Crea una clase Producto con los atributos id (int) y nombre (String). Haz que implemente Ordenable comparando por el id.
Implementa el algoritmo de selección directa
 en un método estático que reciba un vector de Ordenable[] y lo ordene de menor a mayor.
Pista: Busca el elemento más pequeño de la lista y lo intercambias con el de la primera posición, luego el segundo más pequeño, y asi.
*/
public class principal {
    public static void ordenarSeleccion(Ordenable[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            int posMinimo = i;
            // Buscamos el elemento menor en el resto de la lista
            for (int j = i + 1; j < v.length; j++) {
                if (v[j].menorQue(v[posMinimo])) {
                    posMinimo = j;
                }
            }
            // Intercambiamos el menor encontrado con la posición actual [3]
            Ordenable aux = v[i];
            v[i] = v[posMinimo];
            v[posMinimo] = aux;
        }
    }

    public static void main(String[] args) {
        Producto[] lista = {
            new Producto(30, "Monitor"),
            new Producto(10, "Teclado"),
            new Producto(20, "Ratón")
        };

        ordenarSeleccion(lista);

        for (Producto p : lista) System.out.println(p);
    }
}