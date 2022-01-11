package ejercicio2;

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

            int numero;
            do{
                OutputStream salida = conexion.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                System.out.print("Introduce el número que quieres enviar: ");
                numero = new Scanner(System.in).nextInt();
                System.out.println("Enviando información al cliente");
                flujoSalida.writeInt(numero);
            }while(numero > 0);
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
