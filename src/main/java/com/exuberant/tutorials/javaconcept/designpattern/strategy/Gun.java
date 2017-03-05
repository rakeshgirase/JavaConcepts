package com.exuberant.tutorials.javaconcept.designpattern.strategy;

public class Gun implements Weapon {

    @Override
    public void fight() {
        System.out.println("I am fighting using Gun");
    }

}
