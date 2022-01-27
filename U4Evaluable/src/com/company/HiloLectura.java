package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HiloLectura implements Runnable{
    Socket conexion;
    String id;

    public HiloLectura(Socket conexion, String id) {
        this.conexion = conexion;
        this.id = id;
    }

    @Override
    public void run() {
        DataInputStream flujoEntrada = null;
        try {
            // Obtenemos los flujos de datos
            // Flujo de entrada (recepción de información del cliente)
            InputStream entrada = conexion.getInputStream();
            flujoEntrada = new DataInputStream(entrada);

            // Recibimos y enviamos datos al cliente;
            String lineaRecibida;
            do {
                // El servidor primero recibe datos
                lineaRecibida = flujoEntrada.readUTF();
                if (!lineaRecibida.equalsIgnoreCase("fin")) { // Solo mostramos el mensaje recibido si no es "fin"
                    System.out.println("El mensaje recibido es: " + lineaRecibida);
                }
            } while (true); // Leemos líneas y las enviamos hasta que la línea enviada o recibida sea "fin"
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
