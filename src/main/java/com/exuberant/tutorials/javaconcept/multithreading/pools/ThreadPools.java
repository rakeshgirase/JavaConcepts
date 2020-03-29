package com.exuberant.tutorials.javaconcept.multithreading.pools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(Processor.class);

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        logger.info("Starting: [{}]", id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("Got Exception:", e);
        }
        logger.info("Completed: [{}]", id);
    }
}

public class ThreadPools {

    private static Logger logger = LoggerFactory.getLogger(ThreadPools.class);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        logger.info("All tasks submitted.");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }

        logger.info("All tasks completed.");
    }
}