package u2.Ejercicio14_programa;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Programa {
    public static void main(String[] args)
    {
        String[] fileNames = {"cuentalineas1.txt", "cuentalineas2.txt"};
        ArrayList<Process> procesos = new ArrayList<Process>();

        for (String name: fileNames)
        {
            ProcessBuilder processBuilder = new ProcessBuilder();
            ArrayList<String> comandos = new ArrayList<String>();

            comandos.add("java");
            comandos.add("-classpath");
            comandos.add("out/production/u2");
            comandos.add("u2.Ejercicio14_cuentalineas.CuentaLineas");
            comandos.add(name);
            processBuilder.command(comandos);
            try {
                Process proceso = processBuilder.start();
                procesos.add(proceso);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Process proceso:procesos)
        {
            while(proceso.isAlive())
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //Falta abrir los archivos, leer el dato, y mostrarlo por pantalla.
        //Con un bucle abrimos los archivos uno por uno, y sumamos el número
        //de líneas que contiene
    }
}
