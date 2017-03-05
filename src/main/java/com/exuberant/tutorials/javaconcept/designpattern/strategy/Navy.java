package com.exuberant.tutorials.javaconcept.designpattern.strategy;

public class Navy implements Units {

    Weapon weapon;


    public Weapon getWeapon() {
        return weapon;
    }


    @Override
    public void war() {
        System.out.println("We are Navy!!!");
        weapon.fight();
    }
}
