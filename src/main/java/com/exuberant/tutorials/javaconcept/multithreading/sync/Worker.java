package com.exuberant.tutorials.javaconcept.multithreading.sync;

public class Worker {
    private int syncCount = 0;
    private int nonSyncCount = 0;

    public synchronized void syncIncrement() {
        syncCount++;
    }

    public void increment() {
        nonSyncCount++;
    }

    public void run() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    syncIncrement();
                    increment();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    syncIncrement();
                    increment();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Sync Count is: " + syncCount);
        System.out.println("Non Sync Count is: " + nonSyncCount);
    }
}