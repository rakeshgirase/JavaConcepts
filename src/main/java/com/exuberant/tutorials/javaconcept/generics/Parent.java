package com.exuberant.tutorials.javaconcept.generics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent {

    private static Logger logger = LoggerFactory.getLogger(Parent.class);

    public void print() {
        logger.info(String.valueOf(this.getClass()));
    }
}
