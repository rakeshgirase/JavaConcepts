package com.exuberant.tutorials.javaconcept.construcors;

public class ConstructorDemo {
    private static volatile int count = 0;
    public ConstructorDemo() {
        System.err.println("Count:" + ++count);
        new ConstructorDemo();
    }

    public static void main(String[] args) {
        ConstructorDemo c = new ConstructorDemo();
        System.out.println(c);
    }
}
