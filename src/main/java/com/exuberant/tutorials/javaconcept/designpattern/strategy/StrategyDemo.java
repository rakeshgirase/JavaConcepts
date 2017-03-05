package com.exuberant.tutorials.javaconcept.designpattern.strategy;

public class StrategyDemo {

    public static void main(String[] args) {
        Army a = new Army();
        a.setWeapon(new Gun());
        a.war();
        a.setWeapon(new Sword());
        a.war();
    }
}
