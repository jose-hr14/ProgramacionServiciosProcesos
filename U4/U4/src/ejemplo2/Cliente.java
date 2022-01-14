package ejemplo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
            System.out.print("Escribe algo que enviar al servidor: ");
            DataOutputStream flujoSalida = new DataOutputStream(conexion.getOutputStream());
            flujoSalida.writeUTF(new Scanner(System.in).nextLine());
            System.out.println("Enviando información al servidor");
            DataInputStream flujoEntrada = new DataInputStream(conexion.getInputStream());
            System.out.println(flujoEntrada.readUTF());


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
