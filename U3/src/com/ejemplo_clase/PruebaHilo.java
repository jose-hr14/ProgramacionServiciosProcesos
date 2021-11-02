package com.ejemplo_clase;

public class PruebaHilo implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for(int i = 0; i < 1000; i++)
        {
            System.out.println(t.getName() + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
