package Progtema5;

class Trabajador {
    private int id, titulacion, anos;
    private String nombre;
    private char civil, turno; // Civil: S/C, Turno: D/N
    private final int[] BONUS_TIT = {250, 500, 1000, 1250, 1500}; // Map de precios 0-4

    public Trabajador(int id, String nombre, char civil, char turno, int tit, int anos) {
        this.id = id; this.nombre = nombre; this.civil = civil;
        this.turno = turno; this.titulacion = tit; this.anos = anos;
    }

    // Setters (Compactos. NO hay setId)
    public void setNombre(String n) { this.nombre = n; }
    public void setEstadoCivil(char c) { this.civil = c; }
    public void setTurno(char t) { this.turno = t; }
    public void setTitulacion(int t) { this.titulacion = t; }
    public void setAnos(int a) { this.anos = a; }

    public String verDatos() {
        return "ID:" + id + " | " + nombre + " | Civil:" + civil + " | Turno:" + turno + " | Tit:" + titulacion + " | Años:" + anos;
    }

    public double calcularNomina() {
        double bruto = 425 + (anos * 75) + BONUS_TIT[titulacion] + (turno == 'N' ? 100 : 0);
        return civil == 'C' ? bruto * 0.90 : bruto * 0.88; // Resta 10% si casado, 12% si no
    }
}