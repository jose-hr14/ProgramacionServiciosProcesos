package u3.ejercicio01;

import javax.swing.plaf.TableHeaderUI;

public class Hilo implements Runnable{
    int a;
    int b;

    public Hilo() {
    }

    public Hilo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for(int i = a; i <= b; i++)
        {
            System.out.println(thread.getName() + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
