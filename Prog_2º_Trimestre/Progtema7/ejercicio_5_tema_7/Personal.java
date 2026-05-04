package Progtema7.ejercicio_5_tema_7;

public abstract class Personal {
    
    // 6. DECLARAR ATRIBUTO ABSTRACTO
    // ERROR: En Java NO existen los atributos abstractos. 
    // Los atributos siempre tienen que tener un tipo y existir.
    // abstract String nombre; // <-- Esto daría error de compilación.
    
    protected String nombre;

    public Personal(String nombre) {
        this.nombre = nombre;
    }

    // 1. MÉTODO NO ABSTRACTO (Tiene cuerpo)
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }

    // 2. MÉTODO ABSTRACTO (Sin cuerpo, termina en ';')
    public abstract void trabajar();

    // 3. PONER CUERPO A UN MÉTODO ABSTRACTO
    // ERROR: Un método abstracto, por definición, NO puede tener cuerpo {}.
    /*
    public abstract void descansar() { 
        System.out.println("Descansando..."); 
    } 
    */
}