package ejemplo_cuenta1;

public class HiloIngreso implements Runnable{
    Cuenta cuenta;

    public HiloIngreso(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
       for(int i = 0; i < 100; i++)
       {
           cuenta.ingresar(100);
       }
    }
}
