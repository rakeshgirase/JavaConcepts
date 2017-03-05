package com.exuberant.tutorials.javaconcept.port;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener {
    public static void main(String[] args) throws IOException {
        int port = 7777;
        ServerSocket srv = new ServerSocket(port);
        while (true) {
            // Wait for connection from client.
            Socket socket = srv.accept();
            InputStream str = socket.getInputStream();
            System.out.println(str.toString());

        }
    }
}
