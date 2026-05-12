package Ejercicios_Finales.segund_evaluacion.ejercicio_9;
/*
Implementa la clase FichaDomino. Una ficha de dominó tiene dos lados y en cada lado hay
un número del 1 al 6 o bien ningún número (blanco). Cuando se crea una ficha, se
proporcionan ambos valores.
Utiliza la clase anterior para crear un Dominó: posee todas las posibles combinaciones, sin
repetir fichas; por ejemplo, las fichas [ 4 | 5 ] y [ 5 | 4 ] son la misma.
Utiliza el Dominó anterior para generar una secuencia de 8 fichas, seleccionadas de forma
aleatoria, que encajen bien y que estén bien colocadas según las reglas del juego del
dominó: dos fichas encajan si se pueden colocar una al lado de la otra. Por ejemplo, las fichas
[ 2 | 5 ] y [ 4 | 5 ] encajan porque se pueden colocar de la forma [ 2 | 5 ] [ 5 | 4 ]; con este
par solo podrán encajar fichas que contengan un 2 o un 4, porque el 5 está encajado.
*/
public class Main {
    public static void main(String[] args) {
        FichaDomino ficha1 = new FichaDomino(2, 5);
        FichaDomino ficha2 = new FichaDomino(4, 5);
        FichaDomino ficha3 = new FichaDomino(2, 4);

        System.out.println("Ficha 1: " + ficha1);
        System.out.println("Ficha 2: " + ficha2);
        System.out.println("Ficha 3: " + ficha3);
    }
}
