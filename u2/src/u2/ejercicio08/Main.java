package u2.ejercicio08;

public class Main {
    public static void main(String[] args) {
        /*
        for(int i = 0; i < Integer.parseInt(args[0]); i++){
            System.out.println(args[1]);
        }
        for(int i = 0; i < Integer.parseInt(args[2]); i++){
            System.out.println(args[3]);
        }
        for(int i = 0; i < Integer.parseInt(args[4]); i++){
            System.out.println(args[5]);
        }*/
        for(int i = 0; i < args.length - 1; i += 2)
        {
            for(int j = 0; j < Integer.parseInt(args[i]); j++)
                System.out.println(args[i + 1]);
        }
    }
}
