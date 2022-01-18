package ejercicio5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Socket cliente = null;
        try {
            System.out.println("---CLIENTE---");
            cliente = new Socket("localhost", 1234); // Conectamos al servidor

            Thread hiloLectura = new Thread(new HiloLectura(cliente));
            hiloLectura.start();
            Thread hiloEscritura = new Thread(new HiloEscritura(cliente));
            hiloEscritura.start();

            hiloLectura.join();
            hiloEscritura.join();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Cerramos conexiones
            System.out.println("Finalizando cliente");
            try {
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
