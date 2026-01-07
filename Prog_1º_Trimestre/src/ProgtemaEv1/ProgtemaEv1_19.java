package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_19 {
    public static void main(String[] args){

        // ... (Generación de L y i1 igual que antes)
        int L = ((int)(Math.random() * 7) + 1) * 4;
        int i1 = (int)(Math.random() * 7); 
        String pN = ""; // Inicializar la primera nota

        // 1. DETERMINAR LA PRIMERA NOTA (pN)
        if (i1 == 0) pN = "do";
        else if (i1 == 1) pN = "re";
        else if (i1 == 2) pN = "mi";
        else if (i1 == 3) pN = "fa";
        else if (i1 == 4) pN = "sol";
        else if (i1 == 5) pN = "la";
        else pN = "si";
        
        String m = pN; // Melodía

        // 2. GENERACIÓN DEL CUERPO
        for (int i = 1; i < L - 1; i++) {
            int iC = (int)(Math.random() * 7);
            
            // Separador y nota concatenada directamente al índice (sin variable nC)
            m += (i % 4 == 0) ? " | " : ", ";
            
            if (iC == 0) m += "do";
            else if (iC == 1) m += "re";
            else if (iC == 2) m += "mi";
            else if (iC == 3) m += "fa";
            else if (iC == 4) m += "sol";
            else if (iC == 5) m += "la";
            else m += "si";
        }
        
        // 3. CIERRE (Penúltima y Última nota)
        m += ((L - 1) % 4 == 0) ? " | " : ", ";
        
        int iP = (int)(Math.random() * 7);
        if (iP == 0) m += "do";
        // ... (el resto de las condiciones if-else if para la penúltima nota)
        else m += "si";

        m += ", " + pN + " ||";
        // ... (Salida)
    }
}