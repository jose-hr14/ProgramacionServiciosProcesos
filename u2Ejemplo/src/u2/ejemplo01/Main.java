package u2.ejemplo01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //ej 7 y 8
    //el parametro de visual studio es /NoSplash
    public static void main(String[] args) {
        Ej01();
    }
    public static void Ej07()
    {
        String opcion = "";
        Scanner teclado = new Scanner(System.in);
        while(opcion != "4")
        {
            System.out.println("Escribe el número: ");
            System.out.println("1. Internet Explorer");
            System.out.println("2. Visual studio");
            System.out.println("3. Audacity");
            System.out.println("4. Salir");
            opcion = teclado.nextLine();
        }
    }
    public static void Ex02(String[] args)
    {
        for(int i = 0; i < args.length; i++)
        {
            System.out.println(args[i]);
        }
    }
    public static void Ej01()
    {
        ProcessBuilder pb = new ProcessBuilder();
        //pb.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "--incognito");

        ArrayList<String> commands = new ArrayList<String>();
        commands.add("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        commands.add("--incognito");

        pb.command();

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
