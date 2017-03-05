package com.exuberant.tutorials.javaconcept.immmutable;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;

public final class ImmutableClass {

    static final Employee e = new Employee(1, "Rakesh", "UNR");

    public static void main(String[] args) {
        e.setEmpId(2);
        System.out.println(e);

    }
}