package ejercicio3;

import java.io.*;
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

            String lineaSalida = "";
            String lineaEntrada = "";
            do{
                InputStream entrada = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);
                lineaEntrada = flujoEntrada.readUTF();
                if(!lineaEntrada.toLowerCase().equals("fin"))
                {
                    System.out.println("Texto recibido: " + lineaEntrada);
                    System.out.print("Escribe algo que enviar al cliente: ");
                    DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
                    lineaSalida = new Scanner(System.in).nextLine();
                    flujoSalida.writeUTF(lineaSalida);
                    System.out.println("Enviando información al cliente");
                }
            }while(!lineaEntrada.toLowerCase().equals("fin") && !lineaSalida.toLowerCase().equals("fin"));
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
