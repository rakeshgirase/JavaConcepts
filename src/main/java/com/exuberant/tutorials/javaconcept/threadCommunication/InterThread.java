package com.exuberant.tutorials.javaconcept.threadCommunication;

class Shared {

    int num = 0;
    boolean isValueSet = false;

    synchronized int get() {
        if (isValueSet == false)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("After Notified From Put");
        System.out.println("consume: " + num);
        isValueSet = false;
        System.out.println("Before NOtifying Get");
        notify();
        return num;
    }

    synchronized void put(int num) {
        if (isValueSet == true)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("After Notified From Get");
        this.num = num;
        System.out.println("Produce: " + num);
        isValueSet = true;
        System.out.println("Before NOtifying Put");
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