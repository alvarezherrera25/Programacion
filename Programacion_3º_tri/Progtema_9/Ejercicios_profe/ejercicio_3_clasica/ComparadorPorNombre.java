package ejercicio_3_clasica;

import java.util.Comparator;

class ComparadorPorNombre implements Comparator<Alumno> {
    @Override
    public int compare(Alumno a1, Alumno a2) {
        int aux = a1.apellido.compareTo(a2.apellido);
        return aux == 0 ? a1.nombre.compareTo(a2.nombre) : aux;
    }
}
