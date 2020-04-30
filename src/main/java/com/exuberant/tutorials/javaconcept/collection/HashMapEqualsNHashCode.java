package com.exuberant.tutorials.javaconcept.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HashMapEqualsNHashCode {

    private static Logger logger = LoggerFactory.getLogger(HashMapEqualsNHashCode.class);

    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        map.put(new Employee("Rakesh", "Girase"), "Hi");
        map.put(new Employee("Roshan", "Girase"), "Bye");
        logger.info("Before: {}", map);
        map.put(new Employee("Rakesh", "Girase"), "hey");
        logger.info("Before Duplicate Key: {}", map);

    }
}

class Employee{
    private static Logger logger = LoggerFactory.getLogger(Employee.class);

    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        logger.info("Equals called for: {}", this);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        com.exuberant.tutorials.javaconcept.collection.Employee employee = (com.exuberant.tutorials.javaconcept.collection.Employee) o;

        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        return lastName != null ? lastName.equals(employee.lastName) : employee.lastName == null;
    }

    @Override
    public int hashCode() {
        logger.info("Hashcode called for: {}", this);
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

