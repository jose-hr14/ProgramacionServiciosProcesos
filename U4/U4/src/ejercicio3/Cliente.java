package ejercicio3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Socket conexion = null;
        try {
            System.out.println("CLIENTE");
            System.out.println("Iniciando conexión");
            conexion = new Socket("127.0.0.1", 1234);
            System.out.println("Conexión establecida");
            String lineaEntrada = "";
            String lineaSalida = "";
            do{
                OutputStream salida = conexion.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                System.out.print("Introduce el texto que quieres enviar: ");
                lineaSalida = new Scanner(System.in).nextLine();
                flujoSalida.writeUTF(lineaSalida);
                if(!lineaSalida.toLowerCase().equals("fin"))
                {
                    System.out.println("Enviando información al servidor");
                    DataInputStream flujoEntrada = new DataInputStream(conexion.getInputStream());
                    lineaEntrada = flujoEntrada.readUTF();
                    if(!lineaEntrada.toLowerCase().equals("fin"))
                        System.out.println("Texto recibido: " + lineaEntrada);
                }
            }while(!lineaEntrada.toLowerCase().equals("fin") && !lineaSalida.toLowerCase().equals("fin"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
