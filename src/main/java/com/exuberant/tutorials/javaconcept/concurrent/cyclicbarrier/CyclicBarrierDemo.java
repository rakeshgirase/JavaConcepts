package com.exuberant.tutorials.javaconcept.concurrent.cyclicbarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static Logger logger = LoggerFactory.getLogger(CyclicBarrierDemo.class);

    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            final int idx = i;
            new Thread(new Runnable() {
                public void run() {
                    logger.info("T: {}: await", idx);
                    try {
                        cb.await();
                    } catch (InterruptedException ex) {
                        logger.info("T: {} : interrupted", idx);
                        return;
                    } catch (BrokenBarrierException ex) {
                        logger.info("T: {} : Broken", idx);
                        return;
                    }
                    logger.info("T: {} : continue", idx);
                }
            }).start();
        }
    }
}
