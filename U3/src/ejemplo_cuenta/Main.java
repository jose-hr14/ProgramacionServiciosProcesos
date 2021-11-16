package ejemplo_cuenta;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cuenta c = new Cuenta();

        HiloIngreso hi = new HiloIngreso(c);
        HiloReintegro hr = new HiloReintegro(c);
        Thread t1 = new Thread(hi);
        Thread t2 = new Thread(hr);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(BaseDatos.getSaldo());
    }
}
