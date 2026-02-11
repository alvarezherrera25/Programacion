class Conjunto {
    private final int MAX = 100;
    private int[] datos = new int[MAX];
    private int cant = 0; 


    private int buscarIndice(int valor) {
        for (int i = 0; i < cant; i++) {
            if (datos[i] == valor) return i;
        }
        return -1; 
    }

    public void vaciar() {
        cant = 0;
    }

    public boolean esMiembro(int valor) {
        return buscarIndice(valor) != -1;
    }

    public void agregar(int valor) {
        // Solo agrega si no existe Y si hay espacio
        if (cant < MAX && buscarIndice(valor) == -1) {
            datos[cant++] = valor;
        }
    }

    public void eliminar(int valor) {
        int pos = buscarIndice(valor);
        if (pos != -1) {
            // Desplazamos los elementos una posición a la izquierda
            for (int i = pos; i < cant - 1; i++) {
                datos[i] = datos[i + 1];
            }
            cant--;
        }
    }

    public void copiar(Conjunto otro) {
        // Copia directa (más rápida y limpia)
        cant = otro.cant;
        for (int i = 0; i < cant; i++) {
            datos[i] = otro.datos[i];
        }
    }

    public boolean esIgual(Conjunto otro) {
        if (cant != otro.cant) return false;
        // Verificamos que todos los elementos de aquí estén en el otro
        for (int i = 0; i < cant; i++) {
            if (!otro.esMiembro(datos[i])) return false;
        }
        return true;
    }

    public void imprimir() {
        System.out.print("{ ");
        for (int i = 0; i < cant; i++) {
            System.out.print(datos[i] + (i < cant - 1 ? ", " : " "));
        }
        System.out.println("}");
    }
}