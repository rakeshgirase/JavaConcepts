package com.exuberant.tutorials.javaconcept.multithreading.object.locks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

    private static Logger logger = LoggerFactory.getLogger(Worker.class);

    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> lockedList1 = new ArrayList<>();
    private List<Integer> lockedList2 = new ArrayList<>();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void stageOne() {
        list1.add(random.nextInt(100));
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            lockedList1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        list2.add(random.nextInt(100));
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            lockedList2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> process());

        Thread t2 = new Thread(() -> process());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        logger.info("Time taken: " + (end - start));
        logger.info("Locked List1: " + lockedList1.size() + "; Locked List2: " + lockedList2.size());
        logger.info("List1: " + list1.size() + "; List2: " + list2.size());
    }
}
