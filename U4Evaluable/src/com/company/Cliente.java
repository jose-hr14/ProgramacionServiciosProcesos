package com.company;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Socket cliente = null;
        try {
            System.out.println("---CLIENTE---");
            cliente = new Socket("localhost", 1234); // Conectamos al servidor
            System.out.print("Introduce un nombre de usuario: ");
            String id = new Scanner(System.in).nextLine();

            Thread hiloLectura = new Thread(new HiloLectura(cliente));
            hiloLectura.start();
            Thread hiloEscritura = new Thread(new HiloEscritura(cliente, id));
            hiloEscritura.start();

            hiloEscritura.join();
        } catch (IOException | InterruptedException e) {
            //e.printStackTrace();
        } finally {
            // Cerramos conexiones
            System.out.println("Finalizando cliente");
            try {
                if (cliente != null) {
                    cliente.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}
