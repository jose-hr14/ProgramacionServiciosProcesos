package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static WriterResultados writerResultados;
    private static ArrayList<Buscador> listaBuscadores;
    private static ArrayList<Thread> listaHilos;
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);
        String opcion = "";
        do{
            System.out.println("1. Lanzar búsquedas.\n2. Mostrar estado de las búsquedas.\n3. Salir.");

            switch (opcion = scanner.nextLine())
            {
                case "1":
                    lanzarBusquedas();
                    break;
                case "2":
                    mostrarEstadoBusquedas();
                    break;
                default:
                    break;
            }
        }while(!opcion.equalsIgnoreCase("3"));
        if(writerResultados != null)
            writerResultados.closeWriter();
    }
    public static void lanzarBusquedas()
    {
        writerResultados = new WriterResultados();
        listaBuscadores = new ArrayList<>();
        listaHilos = new ArrayList<>();
        String nombreFichero;
        String palabra;
        String opcion;
        Buscador nuevoBuscador;
        int id = 0;
        do{
            id++;
            System.out.print("Introduce el nombre del fichero: ");
            nombreFichero = scanner.nextLine();

            System.out.print("Introduce la palabra a buscar: ");
            palabra = scanner.nextLine();

            nuevoBuscador = new Buscador(palabra, nombreFichero, id, writerResultados);
            listaBuscadores.add(nuevoBuscador);

            System.out.print("¿Deseas introducir una nueva búsqueda? ? (s/n): ");
            opcion = scanner.nextLine();
        }while(!opcion.equalsIgnoreCase("n"));

        System.out.println("Lanzando las búsquedas...");
        System.out.println();
        Thread thread;
        for (Buscador buscador: listaBuscadores)
        {
            thread = new Thread(buscador);
            listaHilos.add(thread);
            thread.start();
        }
    }
    public static void mostrarEstadoBusquedas()
    {
        if(listaBuscadores != null)
        {
            String estado = "";
            for(int i = 0; i < listaBuscadores.size(); i++)
            {
                if(listaHilos.get(i).getState().equals(Thread.State.RUNNABLE))
                    estado = "BUSCANDO";
                else if(listaHilos.get(i).getState().equals(Thread.State.TERMINATED))
                    estado = "FINALIZADO";
                System.out.println(listaBuscadores.get(i).getResultadoBusqueda() + " " + estado);
            }
            String opcion;
            do{
                System.out.print("Indica el número de la búsqueda sobre la que quieres ver los resultados \n" +
                        "o 0 para volver al menú: ");
                if((opcion = scanner.nextLine()).equals("0"))
                    return;
            }while(!opcion.matches("[1-" + listaBuscadores.size() + "]"));
            for (String linea: listaBuscadores.get(Integer.parseInt(opcion) - 1).getListaLineas())
            {
                System.out.println(linea);
            }
        }
        else
            System.out.println("No hay búsquedas para mostrar");
    }
}
