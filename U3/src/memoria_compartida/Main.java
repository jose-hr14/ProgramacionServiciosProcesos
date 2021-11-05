package memoria_compartida;

public class Main {
    public static void main(String[] args) {
        //Contador c = new Contador(); Haciendo esto daría problemas, porque lanzaríamos un mismo proceso con varios hilos distintos
        for(int i = 0; i < 5; i++) {
            Contador c = new Contador();
            Thread t= new Thread(c);
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
            Thread.State estadoHilo = t.getState();
            if (estadoHilo == Thread.State.TERMINATED) {
                System.out.println("Hilo terminado");
            }
        }

    }
}
