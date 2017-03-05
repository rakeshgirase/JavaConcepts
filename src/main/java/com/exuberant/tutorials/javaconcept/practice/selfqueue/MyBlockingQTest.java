package com.exuberant.tutorials.javaconcept.practice.selfqueue;

import java.util.concurrent.BlockingQueue;

public class MyBlockingQTest {
    public static void main(String[] args) {
        BlockingQueue<Double> q = new MyBlockingQueue<Double>();
        Thread p = new Thread(new Producer(q));
        Thread c = new Thread(new Consumer(q));
        p.start();
        c.start();
    }
}
