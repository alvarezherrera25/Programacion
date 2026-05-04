package ejercicio_4;
import java.util.*;
public class GestionUsuario {
    
    private static Map<String, String> baseDatos = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do{
            System.out.println("1. Insertar Usuario");
            System.out.println("2. Borrar Usuario");
            System.out.println("3. Modificar Clave");
            System.out.println("4. Validar Clave");
            System.out.println("5. Mostrar Base de Datos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertar();
                case 2 -> borrar();
                case 3 -> modificar();
                case 4 -> validar();
                case 5 -> mostrarBaseDatos();
                case 6 -> System.out.println("Saliendo...");
            }
        } while (opcion != 6);
    }

    public static void insertar() {
        System.out.print("Introduce un nombre de usuario: ");
        String user = sc.nextLine();

        if (baseDatos.containsKey(user)) {
            System.out.println("El usuario ya existe. Inténtalo de nuevo.");
            return; // Añadido para que no siga si el usuario ya existe
        }

        System.out.println("Introduce clave: ");
        String clave = sc.nextLine();

        if (esClaveValida(clave)) {
            baseDatos.put(user, cifrarCesar(clave)); 
            System.out.println("Usuario insertado correctamente.");
        } else {
            System.out.println("Clave no válida. El usuario no se ha insertado.");
        }
    }


    public static void borrar() {
        System.out.println("Usuario a borrar: ");
        String user = sc.nextLine();
        if (baseDatos.remove(user) != null) {
            System.out.println("Usuario borrado correctamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void modificar() {
        System.out.println("Usuario a modificar: ");
        String user = sc.nextLine();

        if (!baseDatos.containsKey(user)) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.println("Introduce nueva clave: ");
        String nuevaClave = sc.nextLine();

        if(esClaveValida(nuevaClave)) {
            baseDatos.put(user, cifrarCesar(nuevaClave));
            System.out.println("Clave modificada correctamente.");
        } else {
            System.out.println("Clave no válida. La clave no se ha modificado.");
        }
    }

    public static void validar() {
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Clave: ");
        String pass = sc.nextLine();

        if (baseDatos.containsKey(user)) {
            if (baseDatos.get(user).equals(cifrarCesar(pass))) {
                System.out.println("ACCESO GARANTIZADO.");
            } else {
                System.out.println("CLAVE INCORRECTA.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void mostrarBaseDatos() {
        if (baseDatos.isEmpty()) {
            System.out.println("La base de datos está vacía.");
        } else {
            System.out.println("\n--- REGISTROS EN SISTEMA (CIFRADOS) ---");
            for (String user : baseDatos.keySet()) {
                System.out.println("Usuario: " + user + " | Hash César: " + baseDatos.get(user));
            }
        }
    }

    public static boolean esClaveValida(String clave) {
        if (clave.isEmpty()) return false;
        for (int i = 0; i < clave.length(); i++) {
            char c = clave.charAt(i);

            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static String cifrarCesar(String clave) {
        String resultado = "";
        int desplazamiento = 3;

        for (int i = 0; i < clave.length(); i++) {
            char c = clave.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + desplazamiento) % 26 + 'A'); // 90 = ((90 - 65 +3) % 26 + 65)
            } else if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + desplazamiento) % 26 + 'a');
            } else if (c >= '0' && c <= '9') {
                c = (char) ((c - '0' + desplazamiento) % 10 + '0');
            }
            resultado += c;
        }
        return resultado;
    }
}



