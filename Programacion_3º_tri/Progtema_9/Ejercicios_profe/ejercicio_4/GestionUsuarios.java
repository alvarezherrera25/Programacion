package ejercicio_4;
import java.util.*;

public class GestionUsuarios {
    // Comprobar que es una letra o un número
    public static boolean esClaveValida(String clave) {
        for (int i = 0; i < clave.length(); i++) {
            char c = clave.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
    // Cifrado cesar
    public static String cifrarCesar (String clave) {
        
    }
}
