package u3.ejercicio01;
//Programa que pida al user dos números y que lance 10 hilos de forma
//que cada uno mostrará los números existentes entre los dos números introducidos por el usuario
//Haz que los hilos se suspendan un segundo cada vez que muestren un número
public class Main {
    public static void main(String[] args) {
        int a = 6;
        int b = 66;
        for (int i = 1; i <= 10; i++) {
            Thread hilo = new Thread(new Hilo(a, b));
            hilo.setName("Hilo " + i + ": ");
            hilo.start();
        }
    }
}
