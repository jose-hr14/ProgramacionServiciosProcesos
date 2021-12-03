package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterResultados {
    File archivo;
    int identificador;
    BufferedWriter bufferedWriter;
    public WriterResultados() {
        this.archivo = new File("busquedas");
        this.identificador = -1;
        try {
            this.bufferedWriter = new BufferedWriter(new FileWriter(archivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public synchronized void writeLine(String linea, int id, String cabecera){
        try {
            if(id != this.identificador)
                bufferedWriter.write(cabecera);
            bufferedWriter.write(linea + " \n");
            identificador = id;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeWriter()
    {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
