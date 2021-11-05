package memoria_compartida;

public class Contador implements Runnable{
    private int contador = 0;

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            contador++;
        }
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " " + contador);
    }
}
