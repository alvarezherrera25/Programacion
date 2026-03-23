package Programacion_3º_tri.Progtema_9.ejemplos_busquedas;

public class BusquedaDicotomica {
    public static void main(String[] args) {
        int[] v = {4,10,11,13,26,27,35,80,138};
        int x = 13;

        int inicio = 0;
        int fin = v.length - 1;
        int pc; 
        boolean encontrado = false;

  
    do {
        pc = (inicio + fin) / 2;
        if (v[pc] == x) {
            encontrado = true;
        } else if (v[pc] < x) {
            inicio = pc + 1;
        } else {
            fin = pc - 1;
        }   
    } while (inicio <= fin && !encontrado); // es <= porque sino no comprobara el ultimo numero.

        if (encontrado) {
            int pcFinal = pc; // o tambien (inicio + fin) / 2. Como inicializamos pc antes del do podemos poner dirctamente la mitad.
            System.out.println("Elemento encontrado en la posición: " + pcFinal);
        } else {
            System.out.println("El número no existe en la lista. Se terminó de buscar en la mitad de la mitad.");
        }
    }
}