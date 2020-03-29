package com.exuberant.tutorials.javaconcept.concurrent.countdownlatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static Logger logger = LoggerFactory.getLogger(CountDownLatchDemo.class);

    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(5);
        new Thread(() -> {
            logger.info("awaiting...");
            try {
                cdl.await();  //U can call this from Any number of threads
            } catch (InterruptedException ex) {
                logger.info("await has been interrupted");
                return;
            }
            logger.info("ready");
        }).start();

        for (int i = 0; i < 5; i++) {
            final int idx = i;
            new Thread(new Runnable() {
                public void run() {
                    logger.info("T" + idx + ":countDown");
                    cdl.countDown();//This has to happen N number of times
                    logger.info("T" + idx + ":continue");
                }
            }).start();
        }
    }

}
