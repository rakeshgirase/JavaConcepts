package com.exuberant.tutorials.javaconcept.concurrent.services;

public class InterruptDemo implements Runnable {

    public static void main(String[] args) {
        System.out.println("Hi");
        Runnable r = new InterruptDemo();
        Thread t = new Thread(r);
        t.start();
        t.interrupt();
        System.out.println("Main Code");
    }

    @Override
    public void run() {
        System.out.println("Thread is sleeping");
        try {
            Thread.sleep(60 * 1000 * 10);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
            e.printStackTrace();
        }
        System.out.println("After Interruption");

    }

}
