package u2.Ejercicio10_repetidor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        System.getProperty("java.class.path");
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("repetidor.txt"));

            /*
            for(int i = 0; i < Integer.parseInt(args[0]); i++){
                printWriter.println(args[1]);
            }
            for(int i = 0; i < Integer.parseInt(args[2]); i++){
                printWriter.println(args[3]);
            }
            for(int i = 0; i < Integer.parseInt(args[4]); i++){
                printWriter.println(args[5]);
            }
            */

            for(int i = 0; i + 1 < args.length; i+= 2)
            {
                for(int y = 0; y < Integer.parseInt(args[i]); y++){
                    printWriter.println(args[i + 1]);
                }
            }

            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
