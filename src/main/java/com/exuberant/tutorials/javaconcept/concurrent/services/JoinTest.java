package com.exuberant.tutorials.javaconcept.concurrent.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinTest {

    private static Logger logger = LoggerFactory.getLogger(JoinTest.class);

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable(15));
        t.setName("MainSide");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Exit Main");
    }
}