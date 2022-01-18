package ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HiloConexionCliente implements Runnable{
    Socket cliente;

    public HiloConexionCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente conectado");
            //Flujo de entrada del primer cliente
            InputStream entrada = cliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            String mensaje = flujoEntrada.readUTF();
            System.out.println("Cliente: " + mensaje);

            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
            flujoSalida.writeUTF("Servidor: soy el servidor");

            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
