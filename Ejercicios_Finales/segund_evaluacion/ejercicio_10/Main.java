package Ejercicios_Finales.segund_evaluacion.ejercicio_10;

/*
Implementa la clase Carta. La carta debe pertenecer a la baraja española, de cuatro palos
(oros, copas, espadas, bastos) y diez posibles valores (as, 2, 3, 4, 5, 6, 7, sota, caballo, rey)
por palo.
Utiliza la clase anterior para crear una Baraja.
Utiliza la Baraja anterior para escoger 10 cartas al azar y mostrarlas como texto: por ejemplo,
"tres de bastos" o "sota de espadas". A continuación, debe mostrar la suma de los valores
de las 10 cartas, teniendo en cuenta que el as vale 1, la sota, 10, el caballo 11 y el rey 12.
*/
public class Main {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Carta[] cartas = baraja.sacarCartas(10);

        int suma = 0;
        for (int i = 0; i < cartas.length; i++) {
            System.out.println(cartas[i]);

            int numero = cartas[i].getNumero();
            if (numero == 8) {
                suma += 10;
            } else if (numero == 9) {
                suma += 11;
            } else if (numero == 10) {
                suma += 12;
            } else {
                suma += numero;
            }
        }

        System.out.println("La suma de los valores de las 10 cartas es: " + suma);
    }
}
