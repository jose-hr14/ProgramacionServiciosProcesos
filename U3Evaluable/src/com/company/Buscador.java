package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Buscador implements Runnable{
    String palabra;
    String nombreArchivo;
    ArrayList<String> listaLineas;
    int numBusqueda;

    public Buscador(String palabra, String nombreArchivo, int numBusqueda) {
        this.palabra = palabra;
        this.nombreArchivo = nombreArchivo;
        this.numBusqueda = numBusqueda;
    }

    public Buscador(String palabra, String nombreArchivo, ArrayList<String> listaLineas, int numBusqueda) {
        this.palabra = palabra;
        this.nombreArchivo = nombreArchivo;
        this.listaLineas = listaLineas;
        this.numBusqueda = numBusqueda;
    }

    public void resultadoBusqueda()
    {
        String linea = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo));
            int contador = 0;
            listaLineas = new ArrayList<>();
            while((linea = bufferedReader.readLine()) != null)
            {
                contador++;
                if(linea.contains(palabra))
                {
                    listaLineas.add(contador + " " + linea);
                }
            }
            //numBusqueda + " " + nombreArchivo + " " + palabra + " " + listaLineas.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return linea;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<String> getListaLineas() {
        return listaLineas;
    }

    public int getNumBusqueda() {
        return numBusqueda;
    }

    @Override
    public void run() {
        resultadoBusqueda();
    }
}
