package com.exuberant.tutorials.javaconcept.practice.batches;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDivider {
    public static void main(String[] args) {
        int batchSize = 5;
        int fromIndex = 0, toIndex = 0;
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 17; i++) {
            numbers.add(i);// Populate the ArrayList
        }
        if (numbers.size() > 0) {
            int batches = (int) Math.ceil((float) numbers.size() / batchSize);
            System.err.println(batches);
            for (int i = 0; i < batches; i++) {
                fromIndex = toIndex;
                toIndex = toIndex + batchSize;
                if (toIndex > numbers.size()) {
                    toIndex = numbers.size();
                }
                System.out.println(numbers.subList(fromIndex, toIndex));

            }
        }
        //System.err.println(numbers.subList(4, 9));
    }
}
