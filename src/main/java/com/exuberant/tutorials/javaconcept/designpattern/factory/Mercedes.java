package com.exuberant.tutorials.javaconcept.designpattern.factory;

public class Mercedes implements Car {
    private String name;

    public Mercedes(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.err.println("I am runing Mercedes " + name);
    }

}
