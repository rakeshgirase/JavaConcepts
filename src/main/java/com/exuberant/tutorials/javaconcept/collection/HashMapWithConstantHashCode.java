package com.exuberant.tutorials.javaconcept.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HashMapWithConstantHashCode {

    private static Logger logger = LoggerFactory.getLogger(HashMapWithConstantHashCode.class);

    public static void main(String[] args) {
        logger.info("When hashCode Returns constant value then equals is called to check");
        Map<Human, String> map = new HashMap<>();
        map.put(new Human("Rakesh", "Girase"), "Hi");
        map.put(new Human("Roshan", "Girase"), "Bye");
        logger.info("Before: {}", map);
        map.put(new Human("Rakesh", "Girase"), "hey");
        logger.info("After Duplicate Key: {}", map);
    }
}

class Human {
    private static Logger logger = LoggerFactory.getLogger(HashMapWithConstantHashCode.class);
    private String firstName;
    private String lastName;
    private int constant = 15;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        logger.info("Equals called for: {}", this);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (firstName != null ? !firstName.equals(human.firstName) : human.firstName != null) return false;
        return lastName != null ? lastName.equals(human.lastName) : human.lastName == null;
    }

    @Override
    public int hashCode() {
        logger.info("HashCode called for: {}", this);
        this.constant = this.constant * 5;
        return constant;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}