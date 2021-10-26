package u2.evaluable1;

import java.io.*;

public class Sumador {

    public static void main(String[] args) {
        String fileName = args[0];

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("files\\" + fileName));

            int contador = 0;
            while(bufferedReader.readLine() != null)
            {
                contador++;
            }
            bufferedReader.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files\\" + fileName + "-suma"));
            bufferedWriter.write(String.valueOf(contador));
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
