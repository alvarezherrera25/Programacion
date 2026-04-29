package ejercicio_3_clasica;

import java.util.Comparator;

class ComparadorPorNota implements Comparator<Alumno> {
    @Override
    public int compare(Alumno a1, Alumno a2) {
        return Double.compare(a2.notaMedia, a1.notaMedia);
    }
}