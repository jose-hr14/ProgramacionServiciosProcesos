package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Buscador implements Runnable{
    String palabra;
    String nombreArchivo;
    ArrayList<String> listaLineas;
    String cabecera;
    int numBusqueda;
    WriterResultados writerResultados;

    public Buscador(String palabra, String nombreArchivo, int numBusqueda, WriterResultados writerResultados) {
        this.palabra = palabra;
        this.nombreArchivo = nombreArchivo;
        this.numBusqueda = numBusqueda;
        this.listaLineas = new ArrayList<>();
        this.writerResultados = writerResultados;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setListaLineas(ArrayList<String> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public void setNumBusqueda(int numBusqueda) {
        this.numBusqueda = numBusqueda;
    }

    public String getResultadoBusqueda()
    {
        return numBusqueda + " " + nombreArchivo + " " + palabra + " " + listaLineas.size();
    }

    public WriterResultados getWriterResultados() {
        return writerResultados;
    }

    public void setWriterResultados(WriterResultados writerResultados) {
        this.writerResultados = writerResultados;
    }

    public void realizarBusqueda()
    {
        String linea = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo));
            int contador = 0;
            listaLineas = new ArrayList<>();
            while((linea = bufferedReader.readLine()) != null)
            {
                contador++;
                if(linea.toUpperCase(Locale.ROOT).contains(palabra.toUpperCase()))
                {
                    listaLineas.add(contador + " " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + nombreArchivo + " no se ha encontrado, no se pudo realizar la búsqueda");
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("El archivo " + nombreArchivo + " no se ha encontrado, no se pudo realizar la búsqueda");
            //e.printStackTrace();
        }
        cabecera = "---------------------------------------------------------------------------------- \n" +
                "Search ID: " + numBusqueda + " File: " + nombreArchivo + " Word: " + palabra + " \n" +
                "---------------------------------------------------------------------------------- \n";
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
        realizarBusqueda();
        for (String linea: listaLineas)
        {
            writerResultados.writeLine(linea, numBusqueda, cabecera);
        }
    }
}
