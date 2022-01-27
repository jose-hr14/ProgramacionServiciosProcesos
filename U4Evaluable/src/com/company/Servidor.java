package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket conexionCliente = null;
        List<Socket> listaClientes = new ArrayList<>();
        System.out.println("---SERVIDOR---");
        try {
            server = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while(true)
            {
                System.out.println("Esperando conexión de un cliente...");
                conexionCliente = server.accept(); // Esperamos que se conecte un cliente
                System.out.println("Cliente conectado en el puerto " + conexionCliente.getPort()); // Se ha conectado un cliente
                listaClientes.add(conexionCliente);

                Thread thread = new Thread(new HiloServidor(conexionCliente, listaClientes));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerramos conexiones
            System.out.println("Finalizando servidor");
            try {
                conexionCliente.close();
                server.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}
