package com.exuberant.tutorials.javaconcept.concurrent.countdownlatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class LatchTest {

    private static Logger logger = LoggerFactory.getLogger(LatchTest.class);

    private static final int COUNT = 10;

    public static void main(String args[]) {
        // CountDownLatch(int count)
        // Constructs a CountDownLatch initialized with the given count.
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch stopSignal = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Worker(startSignal, stopSignal, Integer.toString(i)))
                    .start();
        }
        logger.info("Go");
        startSignal.countDown();
        try {
            stopSignal.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        logger.info("Done");
    }

    private static class Worker implements Runnable {
        CountDownLatch startLatch;

        CountDownLatch stopLatch;

        String name;

        Worker(CountDownLatch startLatch, CountDownLatch stopLatch, String name) {
            this.startLatch = startLatch;
            this.stopLatch = stopLatch;
            this.name = name;
        }

        public void run() {
            try {
                startLatch.await(); // wait until the latch has counted down to
                // zero
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            logger.info("Running: " + name);
            stopLatch.countDown();
        }
    }
}