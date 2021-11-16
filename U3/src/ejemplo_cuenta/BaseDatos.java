package ejemplo_cuenta;

public class BaseDatos {
    private static double saldo;

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        BaseDatos.saldo = saldo;
    }
}
