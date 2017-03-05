package com.exuberant.tutorials.javaconcept.designpattern.decorator;

public class CreamDecorator implements Beverages {
    Beverages bev;

    public CreamDecorator(Beverages bev) {
        super();
        this.bev = bev;
    }

    @Override
    public int getCost() {
        return 5 + bev.getCost();
    }

    @Override
    public void prepare() {
        bev.prepare();
        System.out.println("Adding Sugar");
    }
}
