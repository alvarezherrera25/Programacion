package Progtema7.ejercicio_5_tema_7;

class Administrativo extends Personal {

    public Administrativo(String nombre) {
        super(nombre);
    }

    // ERROR: Prueba a insertar un método que sea abstracto
    // En una clase que no es abstracta, NO puedes tener métodos abstractos.
    // public abstract void archivar(); // <-- Error de compilación.

    // COMPROBACIÓN: Java nos OBLIGA a implementar 'trabajar()'
    // Si borras este método, la clase Administrativo dará error.
    @Override
    public void trabajar() {
        System.out.println(nombre + " está gestionando documentos.");
    }
}