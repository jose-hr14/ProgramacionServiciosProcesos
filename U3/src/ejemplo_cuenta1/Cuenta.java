package ejemplo_cuenta1;

public class Cuenta {
    public synchronized void ingresar(double cantidad){
        System.out.println("Ingreso");
        double saldo = BaseDatos.getSaldo();
        System.out.println("I El saldo actual es " + saldo);
        saldo += cantidad;
        System.out.println("I El nuevo saldo es " + saldo);
        BaseDatos.setSaldo(saldo);
        System.out.println("Fin ingreso");
    }
    public synchronized void reintegro(double cantidad){
        System.out.println("Reintegro");
        double saldo = BaseDatos.getSaldo();
        System.out.println("R El saldo actual es " + saldo);
        saldo -= cantidad;
        System.out.println("R El nuevo saldo es " + saldo);
        BaseDatos.setSaldo(saldo);
        System.out.println("Fin reintegro");
    }
}
