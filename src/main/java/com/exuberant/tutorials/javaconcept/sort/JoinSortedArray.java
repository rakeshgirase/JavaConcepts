package com.exuberant.tutorials.javaconcept.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinSortedArray {

    private static Logger logger = LoggerFactory.getLogger(JoinSortedArray.class);

    public static void main(String[] args) {
        // List<Integer> first = Arrays.asList(12,15,16,45,58,88,89);
        // List<Integer> first = Arrays.asList(1,2,3,4,5,9);
        List<Integer> first = Arrays.asList(89, 99, 100, 255, 253);
        List<Integer> second = Arrays.asList(9, 13, 14, 19, 45, 88);
        logger.info(joinSortedArray(first, second).toString());
    }

    public static List<Integer> joinSortedArray(List<Integer> first,
                                                List<Integer> second) {
        int firstSize = first.size();
        int secondSize = second.size();
        List<Integer> result = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;
        int resultSize = firstSize + secondSize;
        for (int i = 0; i < resultSize; i++) {
            if (firstIndex == firstSize) {
                result.addAll(second.subList(secondIndex, secondSize));
                break;
            } else if (secondIndex == secondSize) {
                result.addAll(first.subList(firstIndex, firstSize));
                break;
            } else {
                if (first.get(firstIndex) < second.get(secondIndex)) {
                    result.add(first.get(firstIndex));
                    firstIndex++;
                } else {
                    result.add(second.get(secondIndex));
                    secondIndex++;
                }
            }
        }

        return result;
    }

    @Deprecated
    public static List<Integer> oldJoinSortedArray(List<Integer> first,
                                                   List<Integer> second) {
        int firstSize = first.size();
        int secondSize = second.size();
        List<Integer> result = new ArrayList<>();
        if (first.get(firstSize - 1) <= second.get(0)) {// Check if last element
            // of first is <= first
            // element of second
            // array
            result.addAll(first);
            result.addAll(second);
        } else if (first.get(0) >= second.get(secondSize - 1)) {// Check if last
            // element of
            // second is >=
            // first element
            // of first
            // array
            result.addAll(second);
            result.addAll(first);
        } else {
            int firstIndex = 0;
            int secondIndex = 0;
            int resultSize = firstSize + secondSize;
            for (int i = 0; i < resultSize; i++) {
                if (firstIndex == firstSize) {
                    result.addAll(second.subList(secondIndex, secondSize));
                    break;
                } else if (secondIndex == secondSize) {
                    result.addAll(first.subList(firstIndex, firstSize));
                    break;
                } else {
                    if (first.get(firstIndex) < second.get(secondIndex)) {
                        result.add(first.get(firstIndex));
                        firstIndex++;
                    } else {
                        result.add(second.get(secondIndex));
                        secondIndex++;
                    }
                }
            }
        }
        return result;
    }
}