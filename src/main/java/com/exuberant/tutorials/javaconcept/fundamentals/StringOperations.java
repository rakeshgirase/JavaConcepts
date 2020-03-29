package com.exuberant.tutorials.javaconcept.fundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringOperations {

    private static Logger logger = LoggerFactory.getLogger(StringOperations.class);

    public static void main(String[] args) {
        String s1 = "rakesh";
        String s2 = "rakesh";
        logger.info("s1= " + s1 + ", s2= " + s2);
        logger.info("s1 == s2: " + (s1 == s2));
        logger.info("s1.equals(s2): " + (s1.equals(s2)));
    }
}
