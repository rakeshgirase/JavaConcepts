package com.exuberant.tutorials.javaconcept.sort.collectionSort;

public class Recursive {
    public static void main(String[] args) {
        System.err.println(recursive(3));

    }

    public static int recursive(int numb) {
        int facto = 0;
        facto = facto * recursive(numb - 1);
        return facto;
    }
}
