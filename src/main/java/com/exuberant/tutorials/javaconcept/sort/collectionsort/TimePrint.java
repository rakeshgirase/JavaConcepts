package com.exuberant.tutorials.javaconcept.sort.collectionsort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class TimePrint {

    private static Logger logger = LoggerFactory.getLogger(TimePrint.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Boolean> status = new HashMap<>();
        status.put("First", true);
        status.put("Second", true);
        logger.info("Before ");
        print(status);
        modify(status);
        logger.info("After ");
        print(status);
    }

    private static void modify(Map<String, Boolean> status) {
        status.put("First", false);
        status.put("Second", false);

    }

    private static void print(Map<String, Boolean> status) {
        logger.info("First " + status.get("First"));
        logger.info("First " + status.get("Second"));

    }

}
