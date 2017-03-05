package com.exuberant.tutorials.javaconcept.designpattern.factory;

public class CarFactory {
    public static Car getCar(String type) {
        Car car = null;
        if (type.equals("Mercedes")) {
            car = new Mercedes("SUV");
        } else if (type.equals("Ferrari")) {
            car = new Ferrari();
        } else if (type.equals("Maruti")) {
            car = new Maruti();
        }
        return car;
    }
}
