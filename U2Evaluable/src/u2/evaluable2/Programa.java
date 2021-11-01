package u2.evaluable2;

import java.io.*;
import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        ArrayList<Process> listaProcesos = new ArrayList<Process>();
        for (String fileName:args) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("java", "-classpath",
                        "out/production/U2Evaluable", "u2.evaluable1.Sumador", fileName);
                Process proceso = processBuilder.start();
                listaProcesos.add(proceso);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Process proceso:listaProcesos) {
            while(proceso.isAlive())
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        int contadorTotal = 0;
        for (String fileName:args) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("files\\" + fileName + "-suma"));
                contadorTotal += Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files\\resultado-final"));) {
            bufferedWriter.write(String.valueOf(contadorTotal));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
