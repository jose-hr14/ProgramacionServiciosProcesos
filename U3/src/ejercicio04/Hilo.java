package ejercicio04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Hilo implements Runnable{
    int frecuenciaSegundos;
    boolean terminar = false;

    public Hilo() {
    }

    public Hilo(int frecuenciaSegundos) {
        this.frecuenciaSegundos = frecuenciaSegundos;
    }

    public int getFrecuenciaSegundos() {
        return frecuenciaSegundos;
    }

    public void setFrecuenciaSegundos(int frecuenciaSegundos) {
        this.frecuenciaSegundos = frecuenciaSegundos;
    }

    public boolean isTerminar() {
        return terminar;
    }

    public void setTerminar(boolean terminar) {
        this.terminar = terminar;
    }

    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("ej04.txt"));
            while(!terminar)
            {
                printWriter.println("Hola mundo");
                TimeUnit.SECONDS.sleep(frecuenciaSegundos);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
