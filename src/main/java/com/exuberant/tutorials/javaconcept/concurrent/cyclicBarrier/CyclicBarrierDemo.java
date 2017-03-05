package com.exuberant.tutorials.javaconcept.concurrent.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            final int idx = i;
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("T" + idx + ": await");
                    try {
                        cb.await();
                    } catch (InterruptedException ex) {
                        System.out.println("T" + idx + ": interrupted");
                        return;
                    } catch (BrokenBarrierException ex) {
                        System.out.println("T" + idx + ": broken");
                        return;
                    }
                    System.out.println("T" + idx + ": continue");
                }
            }).start();
        }
    }
}
