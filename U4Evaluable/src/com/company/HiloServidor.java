package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;

public class HiloServidor implements Runnable{
    Socket cliente;
    List<Socket> listaClientes;

    public HiloServidor(Socket cliente, List<Socket> listaClientes) {
        this.cliente = cliente;
        this.listaClientes = listaClientes;
    }

    @Override
    public void run() {
        String mensaje;
        try {
            while(!cliente.isClosed())
            {
                InputStream entrada = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);

                mensaje = flujoEntrada.readUTF();

                for (Socket clienteDestino: listaClientes) {
                    if(clienteDestino != cliente && !clienteDestino.isClosed()) {
                        DataOutputStream flujoSalida = new DataOutputStream(clienteDestino.getOutputStream());
                        flujoSalida.writeUTF(mensaje);
                    }
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
