package com.exuberant.tutorials.javaconcept.practice.batches;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDivider {

    private static Logger logger = LoggerFactory.getLogger(ArrayListDivider.class);

    public static void main(String[] args) {
        int batchSize = 5;
        int fromIndex = 0, toIndex = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            numbers.add(i);// Populate the ArrayList
        }
        if (numbers.size() > 0) {
            int batches = (int) Math.ceil((float) numbers.size() / batchSize);
            logger.info(String.valueOf(batches));
            for (int i = 0; i < batches; i++) {
                fromIndex = toIndex;
                toIndex = toIndex + batchSize;
                if (toIndex > numbers.size()) {
                    toIndex = numbers.size();
                }
                logger.info(String.valueOf(numbers.subList(fromIndex, toIndex)));

            }
        }
        //logger.info(numbers.subList(4, 9));
    }
}
