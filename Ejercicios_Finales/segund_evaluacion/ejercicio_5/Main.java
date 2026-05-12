package Ejercicios_Finales.segund_evaluacion.ejercicio_5;
/*
Crea las clases Animal, Mamifero, Ave, Gato, Perro, Canario, Pinguino y Lagarto. Crea, al
menos, tres métodos específicos de cada clase e invalida el/los método/s cuando sea
necesario. Prueba las clases creadas en un conductor en el que se instancien objetos y se les
apliquen métodos.
*/
public class Main {
    public static void main(String[] args) {
        Ave miAve = new Ave("Pájaro", 2);
        Canario miCanario = new Canario("Canarito", 1);
        Pinguino miPinguino = new Pinguino("Pingu", 3);
        Lagarto miLagarto = new Lagarto("Lagartijo", 4);

        miAve.volar();
        miAve.cantar();
        miAve.hacerSonido();

        miCanario.cantar();
        miCanario.volar();
        miCanario.hacerSonido();

        miPinguino.nadar();
        miPinguino.deslizarse();
        miPinguino.hacerSonido();

        miLagarto.arrastrarse();
        miLagarto.tomarElSol();
        miLagarto.hacerSonido();
    }
}
