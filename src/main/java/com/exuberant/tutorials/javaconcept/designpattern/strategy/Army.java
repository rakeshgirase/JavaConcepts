package com.exuberant.tutorials.javaconcept.designpattern.strategy;

public class Army implements Units {

    Weapon weapon;


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void war() {
        System.out.println("We are Army!!!");
        weapon.fight();
    }

}
