package com.exuberant.tutorials.javaconcept.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandling {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandling.class);

    public static void main(String[] args) {
        logger.info(String.valueOf(name()));
    }

    @SuppressWarnings("finally")
    public static boolean name() {
        try {
            //return true;
            System.exit(0);
            throw new Exception();
        } catch (Exception e) {
            return true;
        } finally {
            //Value in Finally will be returned
            return false;
        }
    }
}
