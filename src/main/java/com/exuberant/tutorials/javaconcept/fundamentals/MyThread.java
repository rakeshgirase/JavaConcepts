package com.exuberant.tutorials.javaconcept.fundamentals;


public class MyThread extends Thread {
    private int id = 0;
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
        /*ThreadMXBean t = ManagementFactory.getThreadMXBean();
		for(long n: t.findDeadlockedThreads()){
			System.out.println(n);
		}*/
    }

    public void run() {
        System.out.println("Running Thread" + this.getName());
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