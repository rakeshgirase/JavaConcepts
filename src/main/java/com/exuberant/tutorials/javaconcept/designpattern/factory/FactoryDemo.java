package com.exuberant.tutorials.javaconcept.designpattern.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("Mercedes");
        car.run();
        car = CarFactory.getCar("Maruti");
        car.run();
        Car merc = CarFactory.getCar("Mercedes");
        merc.run();
        Car merc1 = CarFactory.getCar("Mercedes");
        merc1.run();
        Car merc2 = CarFactory.getCar("Mercedes");
        merc2.run();
        Car merc3 = CarFactory.getCar("Mercedes");
        merc3.run();
    }
}
