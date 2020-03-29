package com.exuberant.tutorials.javaconcept.stringoperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringOperations {

    private static Logger logger = LoggerFactory.getLogger(StringOperations.class);

    public static void main(String[] args) {
        String duplicate = new String("Rakesh");
        String name = "Rakesh";
        if (name == duplicate) {
            logger.info("Equals");
        } else {
            logger.info("Difference");
        }
        StringBuffer buff = new StringBuffer("Rakesh");
        logger.info(String.valueOf(buff));
        logger.info(reverse(name));
    }

    public static String reverse(String reverse) {
        int size = reverse.length();
        int mid = size / 2;
        char[] word = reverse.toCharArray();
        for (int i = (mid - 1), j = (mid + 1); i >= 0 && j < size; i--, j++) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
        }
        return new String(word);
    }
}
