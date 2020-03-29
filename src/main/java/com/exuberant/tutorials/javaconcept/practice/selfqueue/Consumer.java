package com.exuberant.tutorials.javaconcept.practice.selfqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    BlockingQueue<Double> q = null;

    public Consumer(BlockingQueue<Double> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (q) {
                try {
                    if (q.size() == 0) {
                        wait();
                    } else {
                        logger.info(String.valueOf(q.take()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
