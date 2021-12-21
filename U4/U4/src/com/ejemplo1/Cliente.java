package com.ejemplo1;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket conexion = new Socket("127.0.0.1", 12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
