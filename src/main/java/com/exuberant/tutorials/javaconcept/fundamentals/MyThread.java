package com.exuberant.tutorials.javaconcept.fundamentals;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {

    private static Logger logger = LoggerFactory.getLogger(MyThread.class);

    private int id;
    private Common common;

    public MyThread(String name, int no, Common object) {
        super(name);
        common = object;
        id = no;
    }

    public static void main(String[] args) {
        Common c = new Common();
        MyThread t1 = new MyThread("MyThread-1", 0, c);
        MyThread t2 = new MyThread("MyThread-2", 1, c);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        logger.info("Running Thread: [{}]", this.getName());
        try {
            if (id == 0) {
                common.synchronizedMethod();
            } else {
                common.method();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}