package com.exuberant.tutorials.javaconcept.multithreading.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Worker {

    private static Logger logger = LoggerFactory.getLogger(Worker.class);

    private int syncCount = 0;
    private int nonSyncCount = 0;

    public synchronized void syncIncrement() {
        syncCount++;
    }

    public void increment() {
        nonSyncCount++;
    }

    public void run() {
        Thread thread1 = new Thread(() -> incrementAll());
        thread1.start();

        Thread thread2 = new Thread(() -> incrementAll());
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logger.info("Sync Count is: " + syncCount);
        logger.info("Non Sync Count is: " + nonSyncCount);
    }

    private void incrementAll() {
        for (int i = 0; i < 10000; i++) {
            syncIncrement();
            increment();
        }
    }
}