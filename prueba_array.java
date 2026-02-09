import java.util.Scanner;

public class prueba_array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] food = new String [3];

        for(int i = 0 ; i < food.length; i++ ){
        System.out.print("Introduce comida: ");
        food[i] = sc.nextLine();
        }
        for(String comida : food ){
        System.out.println(comida);
        }
    }
}