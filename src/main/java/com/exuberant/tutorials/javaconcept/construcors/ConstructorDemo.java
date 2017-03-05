package com.exuberant.tutorials.javaconcept.construcors;

public class ConstructorDemo {
    public ConstructorDemo() {
        new ConstructorDemo();
    }

    public static void main(String[] args) {
        ConstructorDemo c = new ConstructorDemo();
        System.out.println(c);
    }
}
