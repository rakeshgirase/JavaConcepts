package com.exuberant.tutorials.javaconcept;

public class A {

    public A() {
        System.out.println("Creating instance of A");
    }

    private B b;

    public void setB(B b) {
        System.out.println("Setting property b of A instance");
        this.b = b;
    }

}