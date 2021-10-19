package u2.ejercicio09_programa;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("Introduce el primer número a pasar como parámetro: ");
            String a = new Scanner(System.in).nextLine();
            System.out.print("Introduce el segundo número a pasar como parámetro: ");
            String b = new Scanner(System.in).nextLine();
            System.out.print("Introduce el nombre que tendrá el documento de salida: ");
            String nombreDoc = new Scanner(System.in).nextLine();

            ProcessBuilder processBuilder = new ProcessBuilder("java","-classpath","C:\\Users\\Joshua\\Documents\\GitHub\\ProgramacionServiciosProcesos\\u2\\out\\production\\u2", "u2.ejercicio09_generador.Main", a, b, nombreDoc);
            processBuilder.start();
            System.getProperty("java.class.path");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
