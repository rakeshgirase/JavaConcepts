package com.exuberant.tutorials.javaconcept.practice.selfqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
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
                        System.out.println(q.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
