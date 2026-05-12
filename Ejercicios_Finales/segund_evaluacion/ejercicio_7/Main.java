package Ejercicios_Finales.segund_evaluacion.ejercicio_7;
/*
Las amebas son seres unicelulares de forma cambiante ya que carecen de pared celular.
Fagocitan cualquier cosa que se les pone por delante. Crea la clase Ameba con el atributo
peso, un número entero que indica los microgramos que pesa: será un dato entero. Cuando
se crea la ameba su peso es de 3 microgramos. Al comer, va incrementando su peso; gasta
un microgramo en el proceso de fagocitar y el resto hace que aumente de peso. Por ejemplo,
si come una partícula de 6 microgramos miAmeba.come(6) engordaría 5 microgramos.

Una ameba se puede comer a otra ameba miAmeba.come(otraAmeba). En este caso, sucede
lo mismo que anteriormente, se gasta un microgramo en el proceso de fagocitado y el resto
lo engorda la ameba que come. Por ejemplo, si una ameba de 7 microgramos se come a una
de 4, acaba pesando 10 microgramos; la ameba comida no se destruye pero se quedaría con
un peso de 0 microgramos y ya no podría fagocitar nada. Pero si la ameba de 4 microgramos
intenta comerse a la de 7, no puede.
*/
public class Main {
    public static void main(String[] args) {
        Ameba a1 = new Ameba();
        Ameba a2 = new Ameba();

        System.out.println("Peso inicial de a1: " + a1.getPeso() + " microgramos");
        System.out.println("Peso inicial de a2: " + a2.getPeso() + " microgramos");

        a1.come(6);
        System.out.println("Peso de a1 después de comer 6 microgramos: " + a1.getPeso() + " microgramos");

        a1.come(a2);
        System.out.println("Peso de a1 después de comerse a a2: " + a1.getPeso() + " microgramos");
        System.out.println("Peso de a2 después de ser comida por a1: " + a2.getPeso() + " microgramos");
    }
}
