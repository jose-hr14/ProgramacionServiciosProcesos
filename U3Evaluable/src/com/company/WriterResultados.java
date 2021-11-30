package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterResultados {
    File archivo;
    BufferedWriter bufferedWriter;
    public WriterResultados() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(archivo));
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

    public void writeLine(String linea){
        try {
            bufferedWriter.write(linea + " \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writerClose()
    {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
