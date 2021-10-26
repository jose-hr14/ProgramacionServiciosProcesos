package u2.Ejercicio14_cuentalineas;

import java.io.*;

public class CuentaLineas {
    public static void main(String[] args) {
        String fileName = args[0];

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(".\\files\\" + fileName));

            int contador = 0;
            while(bufferedReader.readLine() != null)
            {
                contador++;
            }
            bufferedReader.close();

            String[] finalFileName = fileName.split("\\.");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(".\\files\\" + finalFileName[0] + "-numLineas.txt"));
            bufferedWriter.write(contador + "");
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
