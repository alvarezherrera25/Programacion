package ejercicios_notebook.tema_11.ejercicio_3;
/*
Almacenar datos de tipos primitivos (enteros, reales, booleanos) en formato binario para que ocupen menos espacio y sean más rápidos de procesar.
Enunciado:
Crea un programa que utilice DataOutputStream para guardar en un archivo llamado ventas.dat los siguientes datos de una venta:
Un ID de producto (int).
Un precio unitario (float).
Un mensaje de confirmación (String en formato UTF).
Crea una segunda parte del programa que utilice DataInputStream para leer esos datos y mostrarlos por pantalla con el formato: "Producto: %d, Precio: %.2f, Nota: %s".
Gestiona la excepción EOFException para detectar de forma segura cuándo se han terminado de leer los datos
*/
import java.io.*;

public class Main {
    public static void main(String[] args) {
            String filePath = "C:\\Users\\alvarezherrera\\Documents\\Programacion\\ejercicios_notebook\\tema_11\\ejercicio_3\\ventas.dat";
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
                dos.writeInt(12345); // ID de producto
                dos.writeFloat(19.99f); // Precio unitario
                dos.writeUTF("Venta confirmada"); // Mensaje de confirmación
                System.out.println("Datos guardados exitosamente en ventas.dat");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
                int productId = dis.readInt();
                float price = dis.readFloat();
                String confirmationMessage = dis.readUTF();
                System.out.printf("Producto: %d, Precio: %.2f, Nota: %s%n", productId, price, confirmationMessage);
            } catch (EOFException e) {
                System.out.println("Se han leído todos los datos del archivo.");
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }

