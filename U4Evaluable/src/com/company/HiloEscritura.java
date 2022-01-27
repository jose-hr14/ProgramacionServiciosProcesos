package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HiloEscritura implements Runnable{
    Socket conexionCliente;
    String id;

    public HiloEscritura(Socket conexionCliente, String id) {
        this.conexionCliente = conexionCliente;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            // Flujo de salida (envío de información al cliente)
            OutputStream salida = conexionCliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            // Recibimos y enviamos datos al cliente
            System.out.println("Escribe el mensaje: ");
            Scanner sc = new Scanner(System.in);
            String lineaEnviar = "";
            do{
                // El servidor envía solo si no hemos recibido "fin" del cliente
                lineaEnviar =  sc.nextLine();
                System.out.println("Enviamos la información...");
                flujoSalida.writeUTF("Cliente " +conexionCliente.getLocalPort() + ": " + lineaEnviar); // Enviamos los datos
            } while(!lineaEnviar.equalsIgnoreCase("fin")); // Leemos líneas y las enviamos hasta que la línea enviada o recibida sea "fin"
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
