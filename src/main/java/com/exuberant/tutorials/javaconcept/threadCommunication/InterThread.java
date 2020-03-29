package com.exuberant.tutorials.javaconcept.threadCommunication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Shared {

    private static Logger logger = LoggerFactory.getLogger(Shared.class);

    int num = 0;
    boolean isValueSet = false;

    synchronized int get() {
        if (isValueSet == false)
            try {
                wait();
            } catch (InterruptedException e) {
                logger.info("InterruptedException caught");
            }
        logger.info("After Notified From Put");
        logger.info("consume: " + num);
        isValueSet = false;
        logger.info("Before NOtifying Get");
        notify();
        return num;
    }

    synchronized void put(int num) {
        if (isValueSet == true)
            try {
                wait();
            } catch (InterruptedException e) {
                logger.info("InterruptedException caught");
            }
        logger.info("After Notified From Get");
        this.num = num;
        logger.info("Produce: " + num);
        isValueSet = true;
        logger.info("Before NOtifying Put");
        notify();
    }
}

class Producer extends Thread {
    Shared s;

    Producer(Shared s) {
        this.s = s;
        this.start();
    }

    public void run() {
        int i = 1;
        while (true) {
            s.put(i++);
        }
    }
}

class Consumer extends Thread {
    Shared s;

    Consumer(Shared s) {
        this.s = s;
        this.start();
    }

    public void run() {
        while (true) {
            s.get();
        }
    }
}

public class InterThread {
    public static void main(String[] args) {
        Shared s = new Shared();
        new Producer(s);
        new Consumer(s);
    }
}