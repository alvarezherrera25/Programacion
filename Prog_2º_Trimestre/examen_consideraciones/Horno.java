package Prog_2º_Trimestre.examen_consideraciones;

public class Horno extends Electrodomesticos {
    public Horno(int modelo){
        super(modelo, 0x000000);
    }

    @Override
    public boolean debeRevisarse(){return diasDesdeRevision >= 180; }
}
