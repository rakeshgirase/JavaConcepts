package com.exuberant.tutorials.javaconcept.multithreading.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();//Doesn't start a new Thread
        logger.info("Starting new com.exuberant.tutorials.javaconcept.thread...");
        Thread t1 = new Thread(runner);
        t1.start();//Do start a new Thread
        logger.info("Done main!!!");
    }

    @Override
    public void run() {
        try {
            logger.info("Wating For 2 Seconds");
            Thread.sleep(2000);
            logger.info("Done Waiting For 2 Seconds");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Done ThreadName: " + Thread.currentThread().getName());
    }
}
