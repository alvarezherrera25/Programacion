package Prog_2º_Trimestre.examen_consideraciones;

public abstract class Electrodomesticos implements Mantenimiento {
    private final int modelo; 
    private int color; 
    protected int diasDesdeRevision;
    private boolean pintado;

    public Electrodomesticos(int modelo, int colorInicial) {
        this.modelo = modelo;
        this.color = colorInicial;
        this.diasDesdeRevision = 0;
        this.pintado = false;
    }

    public int getModelo(){ return modelo; }

    public int getColor(){ return color; }

    public void pintar(int nuevoColor){
        this.color = nuevoColor;
        this.pintado = true;
    }

    public void diasTranscurridos(){ 
        this.diasTranscurridos(30);;
    }

    public void diasTranscurridos(int dias){
        this.diasDesdeRevision += dias;
    }

    public abstract boolean debeRevisarse();

    public void pasarRevision(){
        this.diasDesdeRevision = 0;
    }
}
