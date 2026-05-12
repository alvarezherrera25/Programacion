package Ejercicios_Finales.segund_evaluacion.ejercicio_6;
/*
Crea la clase Fraccion. Los atributos serán numerador y denominador. Y algunos de los
métodos pueden ser invertir, simplificar, suma, multiplica, divide, etc.
*/
public class Main {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(1, 2);
        Fraccion f2 = new Fraccion(3, 4);

        System.out.println("Fracción 1: " + f1);
        System.out.println("Fracción 2: " + f2);

        System.out.println("Fracción 1 invertida: " + f1.invertir());
        System.out.println("Fracción 1 simplificada: " + f1.simplificar());
        System.out.println("Suma: " + f1.suma(f2));
        System.out.println("Multiplicación: " + f1.multiplica(f2));
        System.out.println("División: " + f1.divide(f2));
    }
}
