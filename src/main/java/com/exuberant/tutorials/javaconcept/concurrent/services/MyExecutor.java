package com.exuberant.tutorials.javaconcept.concurrent.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {

    private static Logger logger = LoggerFactory.getLogger(MyExecutor.class);

    public static void main(String[] args) {
        Executor exe = new MyExecutor();
        exe.execute(new MyRunnable(10));
        logger.info("Completed Main");
    }

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

}
