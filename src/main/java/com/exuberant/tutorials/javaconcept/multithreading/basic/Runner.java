package com.exuberant.tutorials.javaconcept.multithreading.basic;

import java.util.Arrays;
import java.util.Collection;

public class Runner implements Runnable {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
        System.out.println("Starting new com.exuberant.tutorials.javaconcept.thread...");
        Thread t1 = new Thread(runner);
        t1.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            System.out.println("Runer Started :" + i);
            Collection<?> stackTrace = Arrays.asList(Thread.currentThread().getStackTrace());
            stackTrace.stream().forEach(e -> System.out.println("" + e));
            System.out.println("After dumping: ");
            System.out.println("Runer completed :" + i);
        }
    }
}
