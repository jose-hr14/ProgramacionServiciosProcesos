package ejercicio5;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class HiloLectura implements Runnable{
    public HiloLectura(Socket conexion) {
        this.conexion = conexion;
    }

    Socket conexion;
    @Override
    public void run() {
        try {
            // Obtenemos los flujos de datos
            // Flujo de entrada (recepción de información del cliente)
            InputStream entrada = conexion.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            // Recibimos y enviamos datos al cliente;
            String lineaRecibida;
            do{
                // El servidor primero recibe datos
                lineaRecibida = flujoEntrada.readUTF();
                if(!lineaRecibida.equalsIgnoreCase("fin")) { // Solo mostramos el mensaje recibido si no es "fin"
                    System.out.println("El mensaje recibido es: " + lineaRecibida);
                }
            } while(!lineaRecibida.equalsIgnoreCase("fin")); // Leemos líneas y las enviamos hasta que la línea enviada o recibida sea "fin"
            flujoEntrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
