/**
 * Gestiona un conjunto de enteros.
 * Soporta operaciones para: vaciar, agregar un elemento, eliminar un elemento,
 * copiar, verificar la pertenencia de un elemento al conjunto, su posición, comparar y 
 * visualizar los componentes del conjunto.
 *
 * Los conjuntos solo pueden contener un máximo de 100 elementos.
 * * @author Hugo Álvarez Herrera
 * Fecha: 20260216
 */
class Conjunto {
    
    // Cambiado para evitar la 'Ñ' y hacerlo más descriptivo
    private final int CAPACIDAD = 100;
    int[] vector;
    int numeroDeElementos;

    /**
     * Reserva espacio para almacenar el conjunto y gestionarlo
     */
    public Conjunto() {
        // Usamos la constante en lugar del número "quemado"
        vector = new int[CAPACIDAD];
        numeroDeElementos = 0;
    }

    /**
     * Vacía el conjunto lógicamente
     */
    public void vaciar() {
        numeroDeElementos = 0;
    }

    /**
     * Añade un elemento al conjunto
     * @param elemento Elemento a agregar
     * @return true si se agregó correctamente, false si está lleno o duplicado
     */
    public boolean agregar(int elemento) {
        // Comprobar si el conjunto está lleno
        if (numeroDeElementos == CAPACIDAD) {
            return false; // No se pueden meter más elementos
        }

        // Comprobar si el elemento ya está en el conjunto
        for (int i = 0; i < numeroDeElementos; i++) {
            if (vector[i] == elemento) {
                return false; // El elemento ya existe
            }
        }

        // Insertar el elemento y aumentar el contador
        vector[numeroDeElementos++] = elemento;
        return true; 
    }
}