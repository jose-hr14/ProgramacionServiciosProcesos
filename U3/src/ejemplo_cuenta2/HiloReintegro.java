package ejemplo_cuenta2;

public class HiloReintegro implements Runnable{
    Cuenta cuenta;

    public HiloReintegro(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++)
        {
            synchronized (cuenta)
            {
                cuenta.reintegro(100);
            }

        }
    }
}
