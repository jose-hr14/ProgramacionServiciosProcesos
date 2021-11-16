package ejercicio03;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Introduce el número de hilos: ");
        int numeroHilos = new Scanner(System.in).nextInt();
        ArrayList<Thread> listaHilos = new ArrayList<>();
        for(int i = 0; i < numeroHilos; i++)
        {
            Thread hilo = new Thread(new Hilo(i));
            listaHilos.add(hilo);
            hilo.start();
        }
        int hiloTerminado = 0;
        Thread thread;
        while(hiloTerminado < listaHilos.size())
        {
            hiloTerminado = 0;
            for(int i = 0; i < listaHilos.size(); i++)
            {
                thread = listaHilos.get(i);
                System.out.println("Hilo " + i + ": " + listaHilos.get(i).getState());
                if(listaHilos.get(i).getState() == Thread.State.TERMINATED)
                {
                    hiloTerminado++;
                }
            }
            Thread.sleep(1000);
        }
        System.out.println("Chao");



    }
}
