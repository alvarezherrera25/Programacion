package ejercicios_notebook.tema_11.ejercicio_4;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String clave;

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }
}
