package com.exuberant.tutorials.javaconcept.concurrent.blockingqueue.delay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.DelayQueue;

public class DelayQueueExample {

    private static Logger logger = LoggerFactory.getLogger(DelayQueueExample.class);

    public static void main(String[] args) {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        DelayedElement element1 = new DelayedElement(10, "Hi");

        queue.put(element1);

        try {
            char[] charArray = "rakesh".toCharArray();
            Arrays.sort(charArray);
            logger.info(charArray.toString());
            logger.info(String.valueOf(System.currentTimeMillis()));
            DelayedElement element2 = queue.take();
            logger.info(String.valueOf(element2));
            logger.info(String.valueOf(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}