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
        FichaDomino[] domino = new FichaDomino[28];
        int indice = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                domino[indice] = new FichaDomino(i, j);
                indice++;
            }
        }

        FichaDomino[] secuencia = new FichaDomino[8];

        for (int i = 0; i < 8; i++) {
            int indiceAleatorio = (int) (Math.random() * domino.length);
            secuencia[i] = domino[indiceAleatorio];
            domino[indiceAleatorio] = null;
        }

        for (int i = 0; i < secuencia.length; i++) {
            System.out.println(secuencia[i]);
        }

        for (int i = 0; i < secuencia.length - 1; i++) {
            if (secuencia[i].encaja(secuencia[i + 1])) {
                System.out.println("Las fichas " + secuencia[i] + " y " + secuencia[i + 1] + " encajan.");
            }
        }
    }
}
