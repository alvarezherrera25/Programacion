package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 1. Entrada de datos
        System.out.print("Número base: ");
        long num = sc.nextLong();
        System.out.print("Dígito a insertar (0-9): ");
        int dig = sc.nextInt();
        System.out.print("Posición (desde 1, izquierda a derecha): ");
        int pos = sc.nextInt();

        // 2. Variables de trabajo
        long temp = num;              
        int longitudTotal = 0;
        
        // Calcular la longitud total del número
        while (temp > 0) {
            longitudTotal++;
            temp /= 10;
        }

        // 3. Determinar el número de dígitos a la DERECHA de la inserción.
        // Ejemplo: n=12356 (L=5). p=3. countRight = 5 - 3 + 1 = 3. 
        // ¡No! Posición 3 es después del 2. Los dígitos a la derecha son 3, 5, 6. countRight = 3.
        int contador = longitudTotal - pos + 1; 

        // 4. Calcular el factor de potencia necesario para separar
        long factorPotencia = 1;
        int i = 0;
        while (i < contador) {
            factorPotencia *= 10;
            i++;
        }
        
        // 5. Separación del Número
        long parteDerecha = num % factorPotencia;  // Los 'countRight' últimos dígitos
        long parteIzquierda = num / factorPotencia; // El resto de dígitos
        
        // 6. Construcción del Resultado
        // Paso A: Crear un nuevo factor para mover la parte Izquierda
        long nuevoFactorPotencia = factorPotencia * 10;
        
        // Paso B: Unir la parte izquierda con el dígito insertado, y luego añadir la parte derecha
        long resultadoFinal = parteIzquierda * nuevoFactorPotencia + dig * factorPotencia + parteDerecha;

        // 7. Salida
        System.out.println("Número: " + num);
        System.out.println("Inserción en posición " + pos + ": " + resultadoFinal);
    }
}