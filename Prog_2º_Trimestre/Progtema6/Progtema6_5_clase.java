class Disco {
    String titulo, artista;
    Disco(String t, String a) { titulo = t; artista = a; }
}

class Coleccion {
    Disco[] discos = new Disco[100]; 
    int indice = 0;                 

    // Insertar disco
    void insertar(Disco d) {
        if (indice < 100) {
            discos[indice] = d;
            indice++;
        }
    }

    // Eliminar disco (desplazando huecos)
    void eliminar(int pos) {
        if (pos >= 0 && pos < indice) {
            for (int i = pos; i < indice - 1; i++) {
                discos[i] = discos[i + 1];
            }
            indice--;
        }
    }

    // Listar por consola
    void listar() {
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ": " + discos[i].titulo + " - " + discos[i].artista);
        }
    }
}