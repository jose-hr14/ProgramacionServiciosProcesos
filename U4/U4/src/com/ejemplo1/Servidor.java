package com.ejemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        Socket cliente = null;
        ServerSocket servidor = null;
        try {
            System.out.println("SERVIDOR");
            servidor = new ServerSocket(1234);
            System.out.println("Esperando cliente");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");

            while (true) {
                OutputStream salida = cliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                System.out.print("Introduce el texto que quieres enviar: ");
                flujoSalida.writeUTF(new Scanner(System.in).nextLine());
                System.out.println("Enviando información al cliente");
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                System.out.println("Texto recibido: " + flujoEntrada.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                cliente.close();
                servidor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
