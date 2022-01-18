package ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("SERVIDOR");
        ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true)
        {
            try
            {
                System.out.println("Esperando al cliente");
                Socket cliente = servidor.accept();
                Thread hiloConexion = new Thread((new HiloConexionCliente(cliente)));
                hiloConexion.start();

                //Cerramos conexión
                //cliente.close();
                //servidor.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }
}

