package com.exuberant.tutorials.javaconcept.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTester {

    private static Logger logger = LoggerFactory.getLogger(ThreadTester.class);

    //public static int count;

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*Thread t1 = new MyThread("A");
		Thread t2 = new MyThread("B");
		t1.start();
		t2.start();*/
        //Note that only
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new MyThread("A"));
        service.execute(new MyThread("B"));
        service.shutdown();
        while (service.isTerminated() == true) {
            logger.info("I am done");
        }
    }

}
