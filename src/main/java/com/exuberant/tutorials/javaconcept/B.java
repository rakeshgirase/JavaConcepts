package com.exuberant.tutorials.javaconcept;

public class B {

    public B() {
        System.out.println("Creating instance of B");
    }

    private A a;

    public void setA(A a) {
        System.out.println("Setting property a of B instance");
        this.a = a;
    }

}