package com.exuberant.tutorials.javaconcept.concurrent.deadlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Write two threads with two common objects.
//First holds a lock on First object and sleeps for some time 
//and other does the same thing with other object
public class Deadlock extends Thread {

    private static Logger logger = LoggerFactory.getLogger(Deadlock.class);

    public static String str1 = "str1";
    public static String str2 = "str2";


    public static void main(String[] a) {
        Thread myThread = new MyThread();
        Thread yourThread = new YourThread();

        myThread.start();
        yourThread.start();
    }

    private static class MyThread extends Thread {
        public void run() {
            synchronized (str1) {
                logger.info("MyThread Holds lock on object str1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }

                logger.info("MyThread waiting for lock on object str2");
                synchronized (str2) {
                    System.out
                            .println("MyThread Holds lock on objects str1, str2");
                }
            }
        }
    }

    private static class YourThread extends Thread {
        public void run() {
            synchronized (str2) {
                logger.info("YourThread Holds lock on object str2");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out
                        .println("YourThread waiting for lock on object str1");
                synchronized (str1) {
                    System.out
                            .println("YourThread Holds lock on objects str1, str2");
                }
            }
        }
    }
}
