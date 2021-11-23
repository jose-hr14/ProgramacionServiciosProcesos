package ejemplo_cuenta1;

public class HiloReintegro implements Runnable{
    Cuenta cuenta;

    public HiloReintegro(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++)
        {
            cuenta.reintegro(100);
        }
    }
}
