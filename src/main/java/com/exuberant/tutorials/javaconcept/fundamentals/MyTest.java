package com.exuberant.tutorials.javaconcept.fundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum Color {

    BLACK, WHITE;

    private static Logger logger = LoggerFactory.getLogger(Color.class);

    Color() {
    }

    public void print() {
        logger.info("HI");
    }
}

public class MyTest {

    private static Logger logger = LoggerFactory.getLogger(MyTest.class);

    public static void main(String[] args) {
        //logger.info(Color.Rakesh.ordinal());
        logger.info(String.valueOf(hash(2000)));

    }

    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}