package com.exuberant.tutorials.javaconcept.fundamentals;

public class Common {

    public synchronized void synchronizedMethod() {
        System.out.println("synchronizedMethod called");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("synchronizedMethod done");
    }

    public void method() {
        System.out.println("Method called");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method done");
    }
}