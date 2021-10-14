package u2.ejemplo01;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        String option = "";
        Scanner keyboard = new Scanner(System.in);

        while(!option.equals("4")){
            do{
                System.out.println("1. Internet Explorer");
                System.out.println("2. Visual Studio");
                System.out.println("3. Visual Studio Code");
                System.out.println("4. Salir");
                option = keyboard.next();
            }while(!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4"));
        switch (option)
        {
            case "1":
                iExplorer();
                break;
            case "2":
                visualStudio();
                break;
            case "3":
                visualStudioCode();
                break;
            case "4":
                return;
        }
    }


        //pb.command("C:\\Program Files (x86)\\Microsoft Visual Studio\\2019\\Community\\Common7\\IDE\\devenv.exe");
        //pb.command("C:\\Program Files (x86)\\Microsoft Visual Studio\\2019\\Community\\Common7\\IDE\\devenv.exe", "/nosplash");
        //pb.command("C:\\Users\\Joshua\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe");


    }
    public static void iExplorer()
    {
        System.out.print("Type the url you want to visit: ");
        String url = new Scanner(System.in).nextLine();
        try {
            new ProcessBuilder().command("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", url).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void visualStudio()
    {
        String option;
        do {
            System.out.println("Do you want to see the splash screen? Y/N");
            option = new Scanner(System.in).nextLine();

        }while(!option.equals("Y") && !option.equals("N"));
        if(option.equals("Y")) {
            try {
                new ProcessBuilder().command("C:\\Program Files (x86)\\Microsoft Visual Studio\\2019\\Community\\Common7\\IDE\\devenv.exe").start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                new ProcessBuilder().command("C:\\Program Files (x86)\\Microsoft Visual Studio\\2019\\Community\\Common7\\IDE\\devenv.exe", "/nosplash").start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void visualStudioCode(){
        try {
            new ProcessBuilder().command("C:\\Users\\Joshua\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
