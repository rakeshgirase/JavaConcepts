package com.exuberant.tutorials.javaconcept.multithreading.basic;

public class Runner implements Runnable {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();//Doesn't start a new Thread
        System.out.println("Starting new com.exuberant.tutorials.javaconcept.thread...");
        Thread t1 = new Thread(runner);
        t1.start();//Do start a new Thread
        System.err.println("Done main!!!");
    }

    @Override
    public void run() {
        try {
            System.err.println("Wating For 2 Seconds");
            Thread.sleep(2000);
            System.err.println("Done Waiting For 2 Seconds");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("Done ThreadName: " + Thread.currentThread().getName());
    }
}
