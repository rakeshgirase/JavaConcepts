package com.exuberant.tutorials.javaconcept.concurrent.exchanger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(ExchangerRunnable.class);

    Exchanger<Object> exchanger = null;
    Object object = null;

    public ExchangerRunnable(Exchanger<Object> exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    public void run() {
        try {
            Object previous = this.object;

            this.object = this.exchanger.exchange(this.object);

            logger.info(Thread.currentThread().getName() + " exchanged "
                    + previous + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
