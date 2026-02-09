public class Progtema6_4 {
    public static void main (String[] args) {
        int[] numeros1 =  new int [10];
        int[] numeros2 =  new int [10];

        for (int i = 0; i < 10; i++) {
            numeros1[i] = (int)(Math.random() * 5) + 1;
            numeros2[i] = (int)(Math.random() * 5) + 1;
        }

        for (int i = 0; i < numeros1.length; i++) {
            int contador = 0;
            for (int j = 0; j < numeros2.length; j++) {
                if (numeros1[i] == numeros2[j]) {
                    contador++;
                }
            }
            System.out.println("elemento " + (i + 1) + " (" + numeros1[i] + "): " + contador + " veces");
            
        }
    }
}
