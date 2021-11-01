package u2.evaluable1;

import java.io.*;

public class Sumador {

    public static void main(String[] args) {
        String fileName = args[0];

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("files\\" + fileName));

            int suma = 0;
            String linea = "";
            while((linea = bufferedReader.readLine()) != null)
            {
                suma += Integer.parseInt(linea);
            }
            bufferedReader.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files\\" + fileName + "-suma"));
            bufferedWriter.write(String.valueOf(suma));
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
