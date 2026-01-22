package Progtema5;

public class Progtema5_pruebas { 
    
    static private int campoUno;
    private int campoDos;

    public Progtema5_pruebas() { 
        campoDos = 2;
    }

    public static void main(String[] args) {
        
        Progtema5_pruebas objeto = new Progtema5_pruebas();
        
        campoUno = 1;
        
        System.out.println(campoUno);
        
        System.out.println(objeto.campoDos); 
    }
}