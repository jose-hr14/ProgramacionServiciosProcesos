package u2.Ejercicio10_programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String parametros = " ";
        int contador = 1;
        int numero;
        String cadena;
        ArrayList<String> comandos = new ArrayList<String>();

        comandos.add("java");
        comandos.add("-classpath");
        comandos.add(".\\out\\production\\u2");
        comandos.add("u2.Ejercicio10_repetidor.Main");
        //ProcessBuilder pb = new ProcessBuilder("java", "-classpath", "C:\\Users\\Joshua\\Documents\\GitHub\\ProgramacionServiciosProcesos\\u2\\out\\production\\u2", "u2.Ejercicio10_repetidor.Main");
        System.getProperty("java.class.path");

        System.out.println("Escribe los parámetros que quieres introducir, escribe exit para salir");
        while(!parametros.equalsIgnoreCase(""))
        {
           if(contador % 2 == 0)
           {
               System.out.print("Introduce una cadena: ");
               parametros = new Scanner(System.in).nextLine();
               if(!parametros.equals(""))
                comandos.add(parametros);

           }
           else
           {
               System.out.print("Introduce un número: ");
               parametros = new Scanner(System.in).nextLine();
               if(!parametros.equals(""))
                comandos.add(parametros);
           }
           contador++;
        }

        try {
            new ProcessBuilder(comandos).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
