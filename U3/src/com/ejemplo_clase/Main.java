package com.ejemplo_clase;

public class Main {

    public static void main(String[] args) {
        System.out.println("Voy a lanza un hilo");
        Thread pruebaHilo = new Thread(new PruebaHilo());
        pruebaHilo.setName("Mi hilo: ");
        pruebaHilo.setPriority(Thread.NORM_PRIORITY);
        pruebaHilo.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("Soy el main " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
