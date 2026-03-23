package Programacion_3º_tri.Progtema_9.ejemplos_ordenar;

public class OrdenarPorSeleccion {
    public static void main(String[] args) {
        int[] v = {26, 10, 35, 11, 4, 27, 80, 138, 13};
        int n = v.length;

        // Bucle externo: recorre la lista para colocar el menor en cada posición i
        for (int i = 0; i < n - 1; i++) {
            int posMin = i; 

            // Bucle interno: busca el número más pequeño desde i+1 hasta el final
            for (int j = i + 1; j < n; j++) {
                if (v[j] < v[posMin]) {
                    posMin = j; 
                }
            }

            // Intercambio de valores usando la variable auxiliar
            int aux = v[posMin];
            v[posMin] = v[i];
            v[i] = aux;
        }

        System.out.println("Lista ordenada:");
        for (int i = 0; i < n; i++) {
            System.out.print(v[i] + " ");
        }
    }
}

