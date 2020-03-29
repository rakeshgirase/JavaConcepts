package com.exuberant.tutorials.javaconcept.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class UnderstandCollections {

    private static Logger logger = LoggerFactory.getLogger(UnderstandCollections.class);

    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        logger.info(s.toString());
        logger.info(String.valueOf(null == null));
    }
}