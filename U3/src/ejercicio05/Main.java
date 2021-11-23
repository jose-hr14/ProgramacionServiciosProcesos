package ejercicio05;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Log("hola");
        for(int i = 0; i < 5; i++)
        {

            Thread thread = new Thread(runnable);
            thread.start();


        }
    }
}
