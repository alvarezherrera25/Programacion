package Prog_2º_Trimestre.examen_consideraciones;

public class Cafetera extends Electrodomesticos {
    private int serviciosContador = 0;

    public Cafetera(int modelo) {
        super(modelo, 0x000000); 
    }
    
    public void serviciosHechos(int n) { this.serviciosContador += n; }

    @Override
    public boolean debeRevisarse(){ return serviciosContador >= 200; }

    @Override
    public void pasarRevision(){
        super.pasarRevision();
        this.serviciosContador = 0;
    } 
}
