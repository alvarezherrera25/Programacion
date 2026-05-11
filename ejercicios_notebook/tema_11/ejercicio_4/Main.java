package ejercicios_notebook.tema_11.ejercicio_4;
/*
Aprender a guardar objetos completos en el disco y recuperarlos manteniendo su estado interno.
Enunciado:
Crea una clase llamada Usuario que implemente la interfaz Serializable. 
Debe tener dos atributos: nombre y clave.
En el main, crea una instancia de Usuario.
Usa ObjectOutputStream para escribir ese objeto en un archivo llamado usuarios.obj.
Usa ObjectInputStream para leer el objeto del archivo, realiza un casting a la clase Usuario e imprime sus 
datos para verificar que se recuperaron correctamente
*/
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Juan", "12345");
        String filePath = "E:\\HugoAH\\Programacion\\ejercicios_notebook\\tema_11\\ejercicio_4\\usuarios.obj";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(usuario);
            System.out.println("Usuario guardado exitosamente en usuarios.obj");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    } 
}
