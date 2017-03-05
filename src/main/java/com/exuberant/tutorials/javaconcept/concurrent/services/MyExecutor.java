package com.exuberant.tutorials.javaconcept.concurrent.services;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {

    public static void main(String[] args) {
        Executor exe = new MyExecutor();
        exe.execute(new MyRunnable(10));
        System.out.println("Completed Main");
    }

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

}
