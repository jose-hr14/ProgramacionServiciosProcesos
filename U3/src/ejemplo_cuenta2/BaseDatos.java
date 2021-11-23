package ejemplo_cuenta2;

public class BaseDatos {
    private static double saldo;

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        BaseDatos.saldo = saldo;
    }
}
