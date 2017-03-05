package com.exuberant.tutorials.javaconcept.designpattern.decorator;

public class Coffee implements Beverages {

    @Override
    public int getCost() {
        return 45;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Black Coffee");
    }

}
