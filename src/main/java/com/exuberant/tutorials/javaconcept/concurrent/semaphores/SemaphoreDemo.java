package com.exuberant.tutorials.javaconcept.concurrent.semaphores;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        Thread t1 = new Thread(new DoubleResourceGrabber("First ", s1, s2));
        Thread t2 = new Thread(new DoubleResourceGrabber("Second ", s1, s2));//If this is reversed like s2,s1 then deadlock will be created
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }

    private static class DoubleResourceGrabber implements Runnable {

        private String sysname = "";
        private Semaphore first;
        private Semaphore second;

        public DoubleResourceGrabber(String name, Semaphore s1, Semaphore s2) {
            sysname = name;
            first = s1;
            second = s2;
        }

        public void run() {
            try {
                first.acquire();
                System.out.println(sysname + " acquired " + first);
                Thread.sleep(200); // demonstrate deadlock
                second.acquire();
                System.out.println(sysname + " acquired " + second);
                second.release();
                System.out.println(sysname + " released " + second);
                first.release();
                System.out.println(sysname + " released " + first);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}