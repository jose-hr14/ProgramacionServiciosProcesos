package u2.evaluable2;

import java.io.*;
import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        while (true) {
            ArrayList<Process> listaProcesos = new ArrayList<>();
            //Con este bucle, ejecutamos un programa sumador por cada nombre de archivo
            //que haya en el String[] args. Cada proceso se guarda en un array
            for (String fileName : args) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("java", "-classpath",
                            "out/production/U2Evaluable", "u2.evaluable1.Sumador", fileName);
                    Process proceso = processBuilder.start();
                    listaProcesos.add(proceso);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //Con este bucle, recorremos cada proceso que hemos ejecutado, y por cada uno,
            //esperamos 500 milisegundos mientras siga vivo. Así evitamos ejecutar más
            //instrucciones hasta que los procesos hayan acabado
            for (Process proceso : listaProcesos) {
                while (proceso.isAlive()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            int sumadorTotal = 0;
            //Con este último bucle, guardamos y sumamos el número de los archivos resultantes
            //de cada uno de los procesos
            for (String fileName : args) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("files\\" + fileName + "-suma"));
                    sumadorTotal += Integer.parseInt(bufferedReader.readLine());
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //Escribimos el resultado final de la suma de los archivos resultantes en un fichero
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files\\resultado-final"))) {
                bufferedWriter.write(String.valueOf(sumadorTotal));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
