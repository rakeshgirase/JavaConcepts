package com.exuberant.tutorials.javaconcept.concurrent.blockingQueue.delayQEx;

import java.util.Arrays;
import java.util.concurrent.DelayQueue;

public class DelayQueueExample {

    public static void main(String[] args) {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        DelayedElement element1 = new DelayedElement(10, "Hi");

        queue.put(element1);

        try {
            char[] charArray = "rakesh".toCharArray();
            Arrays.sort(charArray);
            System.out.println(charArray);
            System.out.println(System.currentTimeMillis());
            DelayedElement element2 = queue.take();
            System.out.println(element2);
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}