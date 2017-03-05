package com.exuberant.tutorials.javaconcept.fundamentals;

enum Color {
    Rakesh, Roshan;

    Color() {
        System.out.println("HI");
    }

    public void print() {
        System.out.println("HI");
    }
}

public class MyTest {
    public static void main(String[] args) {
        //System.out.println(Color.Rakesh.ordinal());
        System.out.println(hash(2000));

    }

    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}