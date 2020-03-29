package com.exuberant.tutorials.javaconcept.multithreading.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class Processor extends Thread {

    private static Logger logger = LoggerFactory.getLogger(Processor.class);

    private volatile boolean running = true;

    public void run() {

        while (running) {
            logger.info("Running");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class VolatileDemo {

    private static Logger logger = LoggerFactory.getLogger(VolatileDemo.class);

    public static void main(String[] args) {
        Processor pro = new Processor();
        pro.start();

        // Wait for the enter key
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        logger.info("Stopped: " + nextLine);

        pro.shutdown();
        scanner.close();
    }

}