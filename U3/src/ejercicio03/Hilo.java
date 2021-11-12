package ejercicio03;

import java.util.Random;

public class Hilo implements Runnable{
    int idHilo;

    public Hilo() {
    }

    public Hilo(int idHilo) {
        this.idHilo = idHilo;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i ++)
        {
            try {
                System.out.println("Hilo " + idHilo + ": " + i);
                Thread.sleep(new Random().nextInt(1000) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
