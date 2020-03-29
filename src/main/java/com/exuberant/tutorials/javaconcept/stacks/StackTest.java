package com.exuberant.tutorials.javaconcept.stacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StackTest {

    private static Logger logger = LoggerFactory.getLogger(StackTest.class);

    public static void main(String[] args) {
        int min = 101;
        Random r = new Random();
        List<Integer> minColl = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        logger.info("=============Populating Stack===================");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(100);
            logger.info(String.valueOf(num));
            if (min > num) {
                min = num;
                minColl.add(min);
            }
            stack.push(num);
        }
        logger.info("=============Elements in The Stack Top Down===================");
        stack.printStack();
        logger.info("===============Removed Elements=================");
        for (int i = 0; i < 5; i++) {
            int removed = stack.pop();
            if (removed == minColl.get(minColl.size() - 1)) {
                minColl.remove(minColl.size() - 1);
            }
            logger.info(removed + " New Min Is "
                    + minColl.get(minColl.size() - 1));
        }
    }
}