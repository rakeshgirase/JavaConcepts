package com.exuberant.tutorials.javaconcept.multithreading.locks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private static Logger logger = LoggerFactory.getLogger(Runner.class);

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        logger.info("Locked First...");

        logger.info("Waiting ....");
        cond.await();

        logger.info("Woken up!");

        try {
            increment();
        } finally {
            logger.info("Unlocked First");
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        lock.lock();
        logger.info("Locked Second...");
        logger.info("Press the return key!");
        new Scanner(System.in).nextLine();
        logger.info("Got return key!");

        cond.signal();

        try {
            increment();
        } finally {
            lock.unlock();
            logger.info("Unlocked Second");
        }
    }

    public void finished() {
        logger.info("Count is: " + count);
    }
}