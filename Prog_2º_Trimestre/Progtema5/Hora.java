package Progtema5;

public class Hora {
    private int hora;
    private int minutos;
    private int segundos;

    public Hora() {
        this.hora = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Hora(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    // 1. Suma
    public void sumar(int h, int m, int s) {
        this.segundos = this.segundos + s;
        this.minutos = this.minutos + m;
        this.hora = this.hora + h;
        // 1.1 Suma segundos
        if (this.segundos >= 60) {
            this.segundos = this.segundos - 60;
            this.minutos = this.minutos + 1;
        }
        // 1.2 Suma minutos
        if (this.minutos >= 60) {
            this.minutos = this.minutos - 60;
            this.hora = this.hora + 1;
        }
        // 1.3 Suma horas
        if (this.hora >= 24) {
            this.hora = this.hora - 24;
        }
    }

    // 2. Resta
    public void restar(int h, int m, int s) {
        // 1.1 Resta segundos
        this.segundos = this.segundos - s;
        if (this.segundos < 0) {
            this.segundos = this.segundos + 60;
            this.minutos = this.minutos - 1;
        }
        // 1.1 Resta minutos
        this.minutos = this.minutos - m;
        if (this.minutos < 0) {
            this.minutos = this.minutos + 60;
            this.hora = this.hora - 1;
        }
        // 1.1 Resta horas
        this.hora = this.hora - h;
        if (this.hora < 0) {
            this.hora = this.hora + 24;
        }
    }
    // 3. Imprimir
    public String imprimir() {
        return String.format("%02d:%02d:%02d", hora, minutos, segundos);
    }
}