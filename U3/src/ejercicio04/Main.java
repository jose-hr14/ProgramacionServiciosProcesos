package ejercicio04;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Hilo runnable = new Hilo(5);
        Thread hilo = new Thread(runnable);
        hilo.start();
        String parar;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pulsa enter para detener el hilo: ");
        do
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parar = scanner.nextLine();
        }while(parar.equals(""));
        runnable.setTerminar(true);
    }
}
