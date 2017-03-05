package com.exuberant.tutorials.javaconcept.designpattern.factory;

public class Ferrari implements Car {
    private String name;

    public Ferrari() {
    }

    @Override
    public void run() {
        System.err.println("I am runing Ferrari " + name);
    }

}
