package com.exuberant.tutorials.javaconcept.designpattern.decorator;

public class SugarDecorator implements Beverages {
    Beverages bev;

    public SugarDecorator(Beverages bev) {
        super();
        this.bev = bev;
    }

    @Override
    public int getCost() {
        return 20 + bev.getCost();
    }

    @Override
    public void prepare() {
        bev.prepare();
        System.out.println("Adding Cream");
    }
}
