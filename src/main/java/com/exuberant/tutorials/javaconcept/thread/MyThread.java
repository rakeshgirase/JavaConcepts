package com.exuberant.tutorials.javaconcept.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {

    private static Logger logger = LoggerFactory.getLogger(MyThread.class);

    public static int count;
    private String name = "";

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (count < 100) {
            synchronized (MyThread.class) {
                logger.info("Thread [{}]: count: [{}] ", name, ++count);
                MyThread.class.notify();
                try {
                    //logger.info("Before wait" + name );
                    MyThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
