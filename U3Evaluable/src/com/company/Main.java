package com.company;
//main result resultwriter, search, main, 5 clases
//varias busquedas escriben en el mismo archivo, se escribe cabecera solamente cuando elque ha escrito anteriormente es otra busqueda
//debe de haber algo que coordine y use ambos hilos
public class Main {
    public static void main(String[] args)
    {
        WriterResultados writerResultados = new WriterResultados();
        Thread thread1 = new Thread(new Buscador("god", "bible.txt", 1, writerResultados));
        Thread thread2 = new Thread(new Buscador("the", "dalton1.txt", 2, writerResultados));
        Thread thread3 = new Thread(new Buscador("all", "dalton1.txt", 3, writerResultados));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writerResultados.closeWriter();
    }
}
