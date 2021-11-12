package u2.ejercicio09_generador;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        String nombreFichero = args[2];
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(nombreFichero));
            for(int i = a; i <= b; i++)
            {
                printWriter.print(i + " ");
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public static void Generador(int a, int b, String nombreFichero){
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(nombreFichero));
            for(int i = a; i <= b; i++)
            {
                printWriter.print(i);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
}
