package com.exuberant.tutorials.javaconcept.generics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Vector;


public class WildCardDemo {

    private static Logger logger = LoggerFactory.getLogger(WildCardDemo.class);

    public static void main(String[] args) {
        List<String> l = new Vector<>();
        printWildCardData(l);
    }

    public static void printWildCardData(List<?> e) {
        for (Object o : e) {
            logger.info(String.valueOf(o));
        }
    }
}