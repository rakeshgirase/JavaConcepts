package com.exuberant.tutorials.javaconcept.concurrent.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterruptDemo implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(InterruptDemo.class);

    public static void main(String[] args) {
        logger.info("Hi");
        Runnable r = new InterruptDemo();
        Thread t = new Thread(r);
        t.start();
        t.interrupt();
        logger.info("Main Code");
    }

    @Override
    public void run() {
        logger.info("Thread is sleeping");
        try {
            Thread.sleep(60 * 1000 * 10);
        } catch (InterruptedException e) {
            logger.info("interrupted");
            e.printStackTrace();
        }
        logger.info("After Interruption");

    }

}
