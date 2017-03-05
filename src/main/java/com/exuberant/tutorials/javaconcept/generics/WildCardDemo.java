package com.exuberant.tutorials.javaconcept.generics;

import java.util.List;
import java.util.Vector;


public class WildCardDemo {
    public static void main(String[] args) {
        List<String> l = new Vector<String>();
        printWildCardData(l);
    }

    public static void printWildCardData(List<?> e) {
        for (Object o : e) {
            System.out.println(o.toString());
        }
    }
}