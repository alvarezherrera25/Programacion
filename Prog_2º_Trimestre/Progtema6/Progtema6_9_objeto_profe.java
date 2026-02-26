import java.util.Scanner;
private final int MAX_MENUS = 100;

Scanner teclado = new Scanner();
Plato[] platos;
Pedido[] pedidos;
int menusServidos;

private static void crearPlatos(Plato [] platos){
    for (int i = 0; i < platos.length; i++)
        platos[i] = new Plato("Plato"+i, "CosasP"+i,(int)(Math.random()*100+100));
}

private static crearComandas(){
    int numeroDePedidos;
    int numeroDeMenus;
    
    System.out.println("Introduce numero de menus:")
    numeroDeMenus = teclado.nextInt();
    teclado.nextInt();
    while(numeroDeMenus > 0 && menusServidos < MAX_MENUS)
        if (MAX_MENUS - menusServidos > numeroDeMenus){
            pedidos[numeroDePedidos] = new Pedido(numeroDeMenus);
            for ( int i = 0; i < numeroDeMenus(); i++)
                pedido[numeroDePedidos].annadeMenu();
                numeroDePedidos++;
        } 
    System.out.println("Introduce nuemro de menus: ");
    numeroDeMenus = teclado.nextInt();
    teclado.nextLine();
}
private static void mostrarMenus(){
    System.out.println("Muestra menus");
}


public static void main(String[] args){
    int numeroDePedidos;
    int numeroDeMenus;

    crearPlatos(platos = new Plato[6]);
    pedidos = new Pedido[MAX_MENUS];
    System.out.print("Introducir numero de menus: ");

    numeroDeMenus = teclado.nextInt();
    teclado.nextLine();
    
}