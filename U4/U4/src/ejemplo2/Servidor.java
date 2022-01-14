package ejemplo2;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("SERVIDOR");

        while(true)
        {
            try
            {
                ServerSocket servidor = new ServerSocket(1234);
                System.out.println("Esperando al cliente");
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");

                //Flujo de entrada del primer cliente
                InputStream entrada1 = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada1);

                String mensaje = flujoEntrada.readUTF();
                System.out.println("Cliente: " + mensaje);

                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
                flujoSalida.writeUTF("Servidor: soy el servidor");

                //Cerramos conexión
                cliente.close();
                servidor.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }
}

