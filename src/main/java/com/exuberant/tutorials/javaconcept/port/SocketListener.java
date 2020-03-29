package com.exuberant.tutorials.javaconcept.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener {

    private static Logger logger = LoggerFactory.getLogger(SocketListener.class);

    public static void main(String[] args) throws IOException {
        int port = 7777;
        ServerSocket srv = new ServerSocket(port);
        while (true) {
            // Wait for connection from client.
            Socket socket = srv.accept();
            InputStream str = socket.getInputStream();
            logger.info(str.toString());

        }
    }
}
