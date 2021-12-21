package com.ejemplo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("SERVIDOR");
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("Esperando cliente");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
