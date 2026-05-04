package ejercicio_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
calculo escaños elecciones -> numero partidos (N), numero escaños (M) y votos
se divide los votos entre M (NxM cocientes) y se eligen los mayores.
que partidos tienen 5 mayores cocientes: 30000, 25000, 15000, 12500, 12000.
Ordenado numero de votos
No obtengas un 5%  votos emitidos se eliminan y no tienen reparto

Autor: Hugo Álvarez
Fecha: 2024-06-10
 */
public class Elecciones {
    public static void main(String[] args) {
        int numEscanos = 5;
        String [] partidos = {"Part1", "Part2", "Part3", "Part4", "Part5"};
        int [] votos = {10000, 25000, 30000, 12000, 3000};

        int totalVotos = 0;
        for (int v : votos) {
            totalVotos += v;
        }

        double barrera = totalVotos * 0.05;
        System.out.println("Barrera del 5%: " + barrera + " votos");

        // 1. Crear lista de registros para los partidos que superan la barrera
        List<Registro> listaCocientes = new ArrayList<>();

        // 2. Generar cocientes para cada partido que supera la barrera
        for (int i = 0; i < partidos.length; i++) {
            if (votos[i] >= barrera) {
                for (int divisor = 1; divisor <= numEscanos; divisor++) {
                    double division = (double) votos[i] / divisor;
                    listaCocientes.add(new Registro(partidos[i], division));
                }
            } else {
                System.out.println(partidos[i] + " no supera la barrera y no participa en la asignación de escaños.");
            }
        }
        // 3. Ordenar la lista (como le pusimos el Comparable, lo hace solo)
        Collections.sort(listaCocientes);

        // 4. Mostrar los escaños asignados a cada partido
        System.out.println("Los " + numEscanos + " mayores cocientes son:");

        for (int i = 0; i < numEscanos; i++) {
            Registro ganador = listaCocientes.get(i);

            System.out.println(ganador.nombrePartido + " con cociente: " + ganador.cociente);
        }
    }
}
