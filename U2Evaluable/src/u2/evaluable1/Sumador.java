package u2.evaluable1;

import java.io.*;

public class Sumador {

    public static void main(String[] args) {
        String fileName = args[0];

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("files\\" + fileName));

            int sumador = 0;
            String linea;
            //Bucle para leer cada línea del fichero de entrada y sumar el número
            //de cada línea
            while((linea = bufferedReader.readLine()) != null)
            {
                sumador += Integer.parseInt(linea);
            }
            bufferedReader.close();
            //Escribimos el resultado en un fichero cuyo nombre será
            //el nombre del fichero original más -suma
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files\\" + fileName + "-suma"));
            bufferedWriter.write(String.valueOf(sumador));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
