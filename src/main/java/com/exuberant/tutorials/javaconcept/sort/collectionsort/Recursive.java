package com.exuberant.tutorials.javaconcept.sort.collectionsort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Recursive {

    private static Logger logger = LoggerFactory.getLogger(Recursive.class);

    public static void main(String[] args) {
        logger.info(String.valueOf(recursive(3)));

    }

    public static int recursive(int numb) {
        int facto = 0;
        facto = facto * recursive(numb - 1);
        return facto;
    }
}
