package com.exuberant.tutorials.javaconcept.fundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Common {

    private static Logger logger = LoggerFactory.getLogger(Common.class);

    public synchronized void synchronizedMethod() {
        logger.info("synchronizedMethod called");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("synchronizedMethod done");
    }

    public void method() {
        logger.info("Method called");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Method done");
    }
}