package com.exuberant.tutorials.javaconcept.concurrent.countdownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(5);
        new Thread(new Runnable() {
            public void run() {
                System.out.println("awaiting...");
                try {
                    cdl.await();  //U can call this from Any number of threads
                } catch (InterruptedException ex) {
                    System.out.println("await has been iterrupted");
                    return;
                }
                System.out.println("ready");
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            final int idx = i;
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("T" + idx + ":countDown");
                    cdl.countDown();//This has to happen N number of times
                    System.out.println("T" + idx + ":continue");
                }
            }).start();
        }
    }

}
