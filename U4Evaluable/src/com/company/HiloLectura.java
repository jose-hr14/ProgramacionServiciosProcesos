package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HiloLectura implements Runnable{
    Socket conexion;

    public HiloLectura(Socket conexion) {
        this.conexion = conexion;
    }

    @Override
    public void run() {
        DataInputStream flujoEntrada;
        try {
            InputStream entrada = conexion.getInputStream();
            flujoEntrada = new DataInputStream(entrada);
            String lineaRecibida;
            do {
                lineaRecibida = flujoEntrada.readUTF();
                if (!lineaRecibida.equalsIgnoreCase("fin")) {
                    System.out.println(lineaRecibida);
                }
            } while (!conexion.isClosed());
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
