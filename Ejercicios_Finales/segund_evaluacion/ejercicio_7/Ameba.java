package Ejercicios_Finales.segund_evaluacion.ejercicio_7;

public class Ameba {
    private int peso;

    public Ameba() {
        this.peso = 3;
    }

    public int getPeso() {
        return peso;
    }

    public void come(int microgramos) {
        if (microgramos > 1) {
            peso += (microgramos - 1);
        }
    }

    public void come(Ameba otraAmeba) {
        if (otraAmeba.getPeso() > 0 && this.peso > otraAmeba.getPeso()) {
            int microgramos = otraAmeba.getPeso();
            otraAmeba.peso = 0; // La ameba comida se queda con peso 0
            this.come(microgramos); // La ameba que come engorda
        }
    }

    
    
}
