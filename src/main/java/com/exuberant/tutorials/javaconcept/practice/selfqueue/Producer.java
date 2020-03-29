package com.exuberant.tutorials.javaconcept.practice.selfqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(Producer.class);

    BlockingQueue<Double> q;

    public Producer(BlockingQueue<Double> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (q) {
                try {
                    Double d = Math.random();
                    q.put(d);
                    logger.info("Added [{}]", d);
                    if (q.size() == 1) {
                        notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
