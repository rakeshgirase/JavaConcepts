package com.exuberant.tutorials.javaconcept.construcors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConstructorDemo {

    private static Logger logger = LoggerFactory.getLogger(ConstructorDemo.class);

    private static volatile int count = 0;
    public ConstructorDemo() {
        logger.info("Count:" + ++count);
        new ConstructorDemo();
    }

    public static void main(String[] args) {
        ConstructorDemo c = new ConstructorDemo();
        logger.info(String.valueOf(c));
    }
}
