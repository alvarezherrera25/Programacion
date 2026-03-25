package Prog_2º_Trimestre.examen_consideraciones;

public class Frigorifico extends Electrodomesticos {
    public Frigorifico(int modelo){
        super(modelo, 0xFFFFFF);
    }

    public boolean debeRevisarse(){return diasDesdeRevision >= 360; }
}
