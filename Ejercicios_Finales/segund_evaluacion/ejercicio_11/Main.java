package Ejercicios_Finales.segund_evaluacion.ejercicio_11;

/*
Noé es el propietario de una tienda de animales domésticos y te ha pedido que escribas un
programa para la administración, inventariado y facturación de su tienda. Vende perros,
gatos y peces. El programa debe gestionar la raza de los perros y el tipo de comida: en lata
o seca. La raza de los gatos y si tienen garras o no. De los peces, el tipo de pez y si es de agua
dulce o salada.
Todos los animales tienen un costo base de 60€, al cual se le agrega o decrementa su valor
según sus características: si se compra un perro que se alimenta con comida en lata, el costo
se incrementará en un 10%; el costo de los gatos con garras se decrementa en un 5%; y los
peces de agua dulce cuestan un 20% más.
Crea las clases apropiadas y un conductor que, aleatoriamente, genere 100 animales
diferentes y determine su precio, según sus características.
*/
public class Main {
    public static void main(String[] args) {
        Animal[] animales = new Animal[100];

        for (int i = 0; i < animales.length; i++) {
            int random = (int) (Math.random() * 3);
            if (random == 0) {
                animales[i] = new Perro("labrador", "lata");
            } else if (random == 1) {
                animales[i] = new Gato("siames", true);
            } else {
                animales[i] = new Pez("pez payaso", false);
            }
        }
        for (int i = 0; i < animales.length; i++) {
            System.out.println(animales[i].toString() + " precio: " + animales[i].precio());
        }
    }
}
