public class Progtema6_3 {
    public static void main (String[] args) {
        int[] numero =  new int [10];
        System.out.println("Numero: ");
        for (int i = 0 ; i < numero.length; i++){
            numero[i] = (int)(Math.random() * 100);
            System.out.println(numero[i]);
        }
        int mayor = numero[0];
        int menor = numero[0];
        int posMayor = 0;
        int posMenor = 0;
        for (int i = 1; i < numero.length; i++) {
            if (numero[i] > mayor) {
                mayor = numero[i];
                posMayor = i;
            }
            if (numero[i] < menor) {
                menor = numero[i];
                posMenor = i;
            }
        }
        System.out.println("Numeor mayor: " + mayor);
        System.out.println("Posicion mayor: " + posMayor);
        System.out.println("Numeor menor: " + menor);
        System.out.println("Posicion menor: " + posMenor);
    }
}
