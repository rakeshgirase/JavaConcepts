package com.exuberant.tutorials.javaconcept.designpattern.decorator;

public class MilkDecorator implements Beverages {
    Beverages bev;

    public MilkDecorator(Beverages bev) {
        super();
        this.bev = bev;
    }

    @Override
    public int getCost() {
        return 25 + bev.getCost();
    }

    @Override
    public void prepare() {
        System.out.println("Adding Milk");
        bev.prepare();
    }

}
