package com.exuberant.tutorials.javaconcept.concurrent.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MyRunnable will count the sum of the number from 1 to the parameter
 * countUntil and then write the result to the console.
 * <p>
 * MyRunnable is the task which will be performed
 *
 * @author Lars Vogel
 */

public class MyRunnable implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(MyRunnable.class);

    public final static boolean temp = true;
    private final long countUntil;

    MyRunnable(long countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        logger.info(String.valueOf(sum));
    }
}