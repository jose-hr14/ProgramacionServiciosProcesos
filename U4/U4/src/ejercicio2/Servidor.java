package ejercicio2;

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

            int numero, suma;
            suma = 0;
            do
            {
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                numero = flujoEntrada.readInt();
                suma += numero;
                System.out.println("Numero recibido: " + numero);
            }while(numero > 0);
            System.out.println("La suma total de los números es: " + suma);
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
