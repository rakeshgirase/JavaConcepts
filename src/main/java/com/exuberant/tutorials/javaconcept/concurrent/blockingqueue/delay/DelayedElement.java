package com.exuberant.tutorials.javaconcept.concurrent.blockingqueue.delay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed, Comparable<Delayed> {

    private static Logger logger = LoggerFactory.getLogger(DelayedElement.class);

    private long delayTime;
    private long insertionTime;
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
    public int compareTo(Delayed delayed) {
        int result = 0;
        if (delayed instanceof DelayedElement) {
            DelayedElement to = (DelayedElement) delayed;
            if (this.getDelayTime() < to.getDelayTime()) {
                result = -1;
            } else if (this.getDelayTime() > to.getDelayTime()) {
                result = 1;
            }
        }
        logger.info("CompareTo Result: [{}]", result);
        return result;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long result = unit.convert(delayTime - (System.currentTimeMillis() - insertionTime), TimeUnit.SECONDS);
        logger.info("getDelay is: [{}]", result);
        return result;
    }
}
