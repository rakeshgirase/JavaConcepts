package com.exuberant.tutorials.javaconcept.sort.collectionSort;

import java.util.HashMap;
import java.util.Map;


public class TimePrint {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Boolean> status = new HashMap<String, Boolean>();
        status.put("First", true);
        status.put("Second", true);
        System.out.println("Before ");
        print(status);
        modify(status);
        System.out.println("After ");
        print(status);
    }

    private static void modify(Map<String, Boolean> status) {
        status.put("First", false);
        status.put("Second", false);

    }

    private static void print(Map<String, Boolean> status) {
        System.err.println("First " + status.get("First"));
        System.err.println("First " + status.get("Second"));

    }

}
