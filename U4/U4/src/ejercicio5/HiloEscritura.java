package ejercicio5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HiloEscritura implements Runnable{
    Socket conexionCliente;

    public HiloEscritura(Socket conexionCliente) {
        this.conexionCliente = conexionCliente;
    }

    @Override
    public void run() {
        try {
            // Flujo de salida (envío de información al cliente)
            OutputStream salida = conexionCliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            // Recibimos y enviamos datos al cliente
            System.out.println("Escribe la línea de texto a enviar: ");
            Scanner sc = new Scanner(System.in);
            String lineaEnviar = "";
            do{
                // El servidor envía solo si no hemos recibido "fin" del cliente
                lineaEnviar =  sc.nextLine();
                System.out.println("Envío información al cliente...");
                flujoSalida.writeUTF(lineaEnviar); // Enviamos los datos
            } while(!lineaEnviar.equalsIgnoreCase("fin")); // Leemos líneas y las enviamos hasta que la línea enviada o recibida sea "fin"
            conexionCliente.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
