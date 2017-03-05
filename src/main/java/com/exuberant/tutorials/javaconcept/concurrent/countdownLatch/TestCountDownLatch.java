package com.exuberant.tutorials.javaconcept.concurrent.countdownLatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws Exception {
        List<String> horseList = Collections
                .synchronizedList(new ArrayList<String>());
        // all horse threads wait for only one start latch
        CountDownLatch startLatch = new CountDownLatch(1);
        // all horse has to pass end latch , so initiating with no of horses
        CountDownLatch endLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new HorseThread(String.valueOf(i), startLatch, endLatch, horseList)
                    .start();
        }
        // Start the race
        startLatch.countDown();
        // wait till a endLatch count is 0 (endLatch.countDown() called 5 times)
        endLatch.await();
        System.out.println("First position Horse is Horse No "
                + horseList.get(0));
        System.out.println("Second position Horse is Horse No "
                + horseList.get(1));
    }
}

class HorseThread extends Thread {
    List<String> list;
    private String horseId;
    private CountDownLatch startLatch, endLatch;

    public HorseThread(String horseId, CountDownLatch startLatch,
                       CountDownLatch endLatch, List<String> list) {
        this.horseId = horseId;
        this.startLatch = startLatch;
        this.endLatch = endLatch;
        this.list = list;
    }

    public void run() {
        try {
            // wait till start latch opened
            startLatch.await();
            sleep(new Random().nextInt(10) * 100);
            // notify race end crossed,endLatch decrease count;
            endLatch.countDown();
            list.add(horseId);
            // System.out.println("Horse "+horseId +" has completed.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}