package com.exuberant.tutorials.javaconcept.multithreading.shared.resource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VisibilityAndLocksDemo {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        VisibilityAndLocksDemo c1 = new VisibilityAndLocksDemo();
        long start = System.nanoTime();
        c1.synchronizedIncrement();
        long end = System.nanoTime();
        System.err.println("Time Taken Syncronized: " + (end - start));
        VisibilityAndLocksDemo c2 = new VisibilityAndLocksDemo();
        c2.doIncrement();
        long end2 = System.nanoTime();
        System.err.println("Time Taken: " + (end2 - end));
        VisibilityAndLocksDemo c3 = new VisibilityAndLocksDemo();
        c3.doLockedIncrement();
        long end3 = System.nanoTime();
        System.err.println("Locked Time Taken: " + (end3 - end2));
    }

    private void falseIncrement() {
        for (int i = 0; i < 10000; i++) {
            ++count;
        }
    }

    private synchronized void syncronizedIncrement() {
        for (int i = 0; i < 10000; i++) {
            ++count;
        }
    }

    private void doIncrement() throws InterruptedException {
        Thread t1 = new Thread(this::falseIncrement);
        Thread t2 = new Thread(this::falseIncrement);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.err.println("doIncrement: The ideal count shud be 20000 but the count is " + count);
    }

    private void synchronizedIncrement() throws InterruptedException {
        Thread t1 = new Thread(this::syncronizedIncrement);
        Thread t2 = new Thread(this::syncronizedIncrement);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.err.println("doLockedIncrement: The ideal count shud be 20000 but the count is " + count);
    }

    private void doLockedIncrement() throws InterruptedException {
        Thread t1 = new Thread(this::reentrantLockIncrement);
        Thread t2 = new Thread(this::reentrantLockIncrement);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.err.println("doLockedIncrement: The ideal count shud be 20000 but the count is " + count);
    }

    private void reentrantLockIncrement() {

        for (int i = 0; i < 10000; i++) {
            lock.lock();
            ++count;
            lock.unlock();
        }

    }
}
