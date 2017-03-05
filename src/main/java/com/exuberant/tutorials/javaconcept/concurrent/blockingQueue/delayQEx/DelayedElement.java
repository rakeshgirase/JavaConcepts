package com.exuberant.tutorials.javaconcept.concurrent.blockingQueue.delayQEx;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed, Comparable<Delayed> {
    private long delayTime;
    private long insertionTime = System.currentTimeMillis();
    private String name;


    public DelayedElement(long delayTime, String name) {
        super();
        this.delayTime = delayTime;
        this.insertionTime = System.currentTimeMillis();
        this.name = name;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public String toString() {
        return "DelayedElement [delayTime=" + delayTime + ", name=" + name
                + "]";
    }

    public long getInsertionTime() {
        return insertionTime;
    }

    public void setInsertionTime(long insertionTime) {
        this.insertionTime = insertionTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Delayed elem) {
        int result = 1;
        if (elem instanceof DelayedElement) {
            DelayedElement to = (DelayedElement) elem;
            if (this.getDelayTime() < to.getDelayTime()) {
                result = -1;
            } else if (this.getDelayTime() > to.getDelayTime()) {
                result = 1;
            } else if (this.getDelayTime() < to.getDelayTime()) {
                result = 0;
            }
        }
        System.out.println("CompareTo Result " + result);
        return result;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long result = unit.convert(delayTime - (System.currentTimeMillis() - insertionTime), TimeUnit.SECONDS);
        System.out.println("getDelay is " + result);
        return result;
    }


}
