import java.util.Scanner;

public class Progtema6_2 {
    public static void main (String[] args) {
        int[] vector1 =  {1,2,3,4,5,6,7,8,9,10};
        int[] vector2 =  {1,2,3,4,5,6,7,8,9,10}; 
        int[] vector3 =  new int [10];

        for (int i = 0 ; i < 10 ; i++){
            vector3[i] = vector1[i] + vector2[i];
            System.out.println(vector3[i]);
        }
    }
}
