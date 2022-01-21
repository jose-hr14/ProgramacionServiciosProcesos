package ejercicio5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket conexionCliente = null;
        try {
            System.out.println("---SERVIDOR---");
            server = new ServerSocket(1234);
            System.out.println("Esperando conexión de un cliente...");
            conexionCliente = server.accept(); // Esperamos que se conecte un cliente
            System.out.println("¡Cliente conectado!"); // Se ha conectado un cliente

            Thread hiloLectura = new Thread(new HiloLectura(conexionCliente));
            hiloLectura.start();
            Thread hiloEscritura = new Thread(new HiloEscritura(conexionCliente));
            hiloEscritura.start();

            hiloLectura.join();
            hiloEscritura.join();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (InterruptedException e) {
            //e.printStackTrace();
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
