package com.exuberant.tutorials.javaconcept.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTester {

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
            System.out.println("I am done");
        }
    }

}
