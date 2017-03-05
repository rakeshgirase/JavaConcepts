package com.exuberant.tutorials.javaconcept.multithreading.locks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

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
        System.err.println("Locked First...");

        System.out.println("Waiting ....");
        cond.await();

        System.out.println("Woken up!");

        try {
            increment();
        } finally {
            System.err.println("Unlocked First");
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        lock.lock();
        System.err.println("Locked Second...");
        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");

        cond.signal();

        try {
            increment();
        } finally {
            lock.unlock();
            System.err.println("Unlocked Second");
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }
}