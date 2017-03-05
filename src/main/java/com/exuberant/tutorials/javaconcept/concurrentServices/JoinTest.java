package com.exuberant.tutorials.javaconcept.concurrentServices;

public class JoinTest {

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable(15));
        t.setName("MainSide");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exit Main");
    }
}