package com.exuberant.tutorials.javaconcept.multithreading.shared.resource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface Incrementor {

    void increment(int number);

    int getCount();
}

public class BetterVisibilityAndLocksDemo {
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        int number = 10000;
        BetterVisibilityAndLocksDemo dumy = new BetterVisibilityAndLocksDemo();
        Worker.doIncrement(new NormalIncrementor(dumy), number);
        BetterVisibilityAndLocksDemo c2 = new BetterVisibilityAndLocksDemo();
        Worker.doIncrement(new SyncronizedIncrementor(c2), number);
        BetterVisibilityAndLocksDemo c3 = new BetterVisibilityAndLocksDemo();
        Worker.doIncrement(new LockedIncrementor(c3), number);
        BetterVisibilityAndLocksDemo c1 = new BetterVisibilityAndLocksDemo();
        Worker.doIncrement(new NormalIncrementor(c1), number);
    }

    public void increment() {
        ++count;
    }

    public int getCount() {
        return count;
    }
}

class NormalIncrementor implements Incrementor {

    private BetterVisibilityAndLocksDemo object;

    public NormalIncrementor(BetterVisibilityAndLocksDemo object) {
        this.object = object;
    }

    @Override
    public void increment(int number) {
        for (int i = 0; i < number; i++) {
            object.increment();
        }
    }

    @Override
    public int getCount() {
        return object.getCount();
    }
}

class LockedIncrementor extends NormalIncrementor {

    private Lock lock = new ReentrantLock();

    public LockedIncrementor(BetterVisibilityAndLocksDemo object) {
        super(object);
    }

    @Override
    public void increment(int number) {
        lock.lock();
        super.increment(number);
        lock.unlock();
    }
}

class SyncronizedIncrementor extends NormalIncrementor {

    public SyncronizedIncrementor(BetterVisibilityAndLocksDemo object) {
        super(object);
    }


    @Override
    public synchronized void increment(int number) {
        super.increment(number);
    }
}

class Worker {
    public static void doIncrement(Incrementor incrementor, int number) throws InterruptedException {
        long start = System.nanoTime();
        Thread t1 = new Thread(() -> incrementor.increment(number));
        Thread t2 = new Thread(() -> incrementor.increment(number));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.nanoTime();
        System.err.println(incrementor.getClass().getSimpleName() + ": Ideal count: " + 2 * number + " Actual Count: "
                + incrementor.getCount() + " Time Taken:" + (end - start));
    }
}
