package Progtema7.ejercicio_5_tema_7;

package Progtema7;

public class MainErrores {
    public static void main(String[] args) {
        
        // CONDICIÓN 4: Declara un objeto con ese tipo de clase.
        // [CORRECTO] Podemos declarar la variable sin problemas.
        ClaseAbstracta miObjeto;

        // CONDICIÓN 5: Haz un new a dicho objeto (con el nombre de dicha clase).
        // [ERROR INTENCIONADO] No se puede hacer 'new' de una clase abstracta directamente.
        miObjeto = new ClaseAbstracta(); 
    }
}