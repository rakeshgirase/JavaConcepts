package com.exuberant.tutorials.javaconcept.concurrentServices;

import java.util.concurrent.Callable;

/**
 * MyRunnable will count the sum of the number from 1 to the parameter
 * countUntil and then write the result to the console.
 * <p>
 * MyRunnable is the task which will be performed
 *
 * @author Lars Vogel
 */

public class MyCallable implements Callable<Integer> {
    private final int countUntil;

    MyCallable(int countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public Integer call() throws Exception {
        return countUntil;
    }


} 