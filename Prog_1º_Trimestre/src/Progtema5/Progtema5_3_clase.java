package Progtema5;

class trabajador {

    private int id;             
    private String nombre;
    private char estadoCivil;  
    private char turno;        
    private int titulacion;     
    private int aniosEmpresa;


    public trabajador(int id, String nombre, char estadoCivil, char turno, int titulacion, int aniosEmpresa) {
        this.id = id;
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.turno = turno;
        this.titulacion = titulacion;
        this.aniosEmpresa = aniosEmpresa;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }

    public void setTitulacion(int titulacion) {
        if (titulacion >= 0 && titulacion <= 4) {
            this.titulacion = titulacion;
        } else {
            System.out.println("Error: Titulación debe ser entre 0 y 4.");
        }
    }

    public void setAniosEmpresa(int aniosEmpresa) {
        this.aniosEmpresa = aniosEmpresa;
    }


    public String obtenerDatos() {
        return "=== Ficha del Trabajador ===\n" +
               "ID: " + id + "\n" +
               "Nombre: " + nombre + "\n" +
               "Estado Civil: " + (estadoCivil == 'C' ? "Casado" : "Soltero") + "\n" +
               "Turno: " + (turno == 'N' ? "Nocturno" : "Diurno") + "\n" +
               "Titulación (Nivel): " + titulacion + "\n" +
               "Años en la empresa: " + aniosEmpresa;
    }


    public double calcularNomina() {
        double salarioBase = 425.0;


        double plusTurno;
        if (turno == 'N') {
            plusTurno = 100.0;
        } else {
            plusTurno = 0.0;
        }


        double plusAntiguedad = aniosEmpresa * 75.0;


        double plusTitulacion = 0.0;
        switch (titulacion) {
            case 0: plusTitulacion = 250.0; break;
            case 1: plusTitulacion = 500.0; break;
            case 2: plusTitulacion = 1000.0; break;
            case 3: plusTitulacion = 1250.0; break;
            case 4: plusTitulacion = 1500.0; break;
            default: plusTitulacion = 0.0; break;
        }


        double salarioBruto = salarioBase + plusTurno + plusAntiguedad + plusTitulacion;

      
        double porcentajeRetencion;
        if (estadoCivil == 'C') {
            porcentajeRetencion = 0.10;
        } else {
            porcentajeRetencion = 0.12; 
        }
        
        double retencion = salarioBruto * porcentajeRetencion;

        return salarioBruto - retencion;
    }
}
