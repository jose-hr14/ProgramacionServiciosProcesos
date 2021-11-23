package ejercicio05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log implements Runnable{
    String mensaje;

    public Log(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++)
        {
            escribir(this.mensaje);
        }
    }

    public void escribir (String mensaje)
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log.txt", true));
            bufferedWriter.write(String.valueOf(LocalDateTime.now()));
            Thread.sleep(1000);
            bufferedWriter.write(" " + mensaje);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
