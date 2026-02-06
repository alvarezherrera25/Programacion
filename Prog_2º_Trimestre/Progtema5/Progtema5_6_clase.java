package Progtema5;

class Hora {
    private int hora;
    private int minutos;
    private int segundos;

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
        while (this.segundos >= 60) {
            this.segundos = this.segundos - 60;
            this.minutos = this.minutos + 1;
        }
        // 1.2 Suma minutos
        while (this.minutos >= 60) {
            this.minutos = this.minutos - 60;
            this.hora = this.hora + 1;
        }
        // 1.3 Suma horas
        while (this.hora >= 24) {
            this.hora = this.hora - 24;
        }
    }

    // 2. Resta
    public void restar(int h, int m, int s) {
        // 2.1 Resta segundos
        this.segundos = this.segundos - s;
        while (this.segundos < 0) {
            this.segundos = this.segundos + 60;
            this.minutos = this.minutos - 1;
        }
        // 2.2 Resta minutos
        this.minutos = this.minutos - m;
        while (this.minutos < 0) {
            this.minutos = this.minutos + 60;
            this.hora = this.hora - 1;
        }
        // 2.3 Resta horas
        this.hora = this.hora - h;
        while (this.hora < 0) {
            this.hora = this.hora + 24;
        }
    }
    // 3. Imprimir
    public String imprimir() {
        return String.format("%02d:%02d:%02d", hora, minutos, segundos);
    }
}