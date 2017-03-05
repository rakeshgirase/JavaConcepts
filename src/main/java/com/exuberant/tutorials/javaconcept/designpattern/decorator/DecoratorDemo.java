package com.exuberant.tutorials.javaconcept.designpattern.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Beverages b = new CreamDecorator(new MilkDecorator(new SugarDecorator(new Tea())));
        System.out.println(b.getCost());
        b.prepare();

        b = new CreamDecorator(new SugarDecorator(new Coffee()));
        System.out.println(b.getCost());
        b.prepare();
    }
}
