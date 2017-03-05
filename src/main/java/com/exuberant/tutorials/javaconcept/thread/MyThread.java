package com.exuberant.tutorials.javaconcept.thread;

public class MyThread extends Thread {
    public static int count;
    private String name = "";

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (count < 100) {
            synchronized (MyThread.class) {
                System.out.println("Thread " + name + " " + ++count);
                //System.out.println("Before notify" +name );
                MyThread.class.notify();
                try {
                    //System.out.println("Before wait" + name );
                    MyThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
