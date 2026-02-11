public class Progtema6_7_objeto {
    public static void main(String[] args) {
        Conjunto A = new Conjunto();
        
        // Probamos agregar
        A.agregar(5); A.agregar(10); A.agregar(10); A.agregar(15);
        System.out.print("A: "); A.imprimir();

        // Probamos esMiembro
        System.out.println("¿Está el 10? " + A.esMiembro(10));

        // Probamos copiar
        Conjunto B = new Conjunto();
        B.copiar(A);
        System.out.print("B (copia): "); B.imprimir();

        // Probamos eliminar
        A.eliminar(10);
        System.out.print("A sin 10: "); A.imprimir();

        // Probamos esIgual
        System.out.println("¿A == B? " + A.esIgual(B));

        // Probamos vaciar
        A.vaciar();
        System.out.print("A vacio: "); A.imprimir();
    }
}