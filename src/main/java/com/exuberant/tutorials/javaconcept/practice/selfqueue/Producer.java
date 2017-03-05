package com.exuberant.tutorials.javaconcept.practice.selfqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    BlockingQueue<Double> q = null;

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
                    System.out.println("Added " + d);
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
