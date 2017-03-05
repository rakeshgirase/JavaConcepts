package com.exuberant.tutorials.javaconcept.multithreading.communication;

import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true;

    public void run() {

        while (running) {
            System.out.println("Running");

            try {
                Thread.sleep(50);
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

    public static void main(String[] args) {
        Processor pro = new Processor();
        pro.start();

        // Wait for the enter key
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        System.err.println("Stopped: " + nextLine);

        pro.shutdown();
        scanner.close();
    }

}