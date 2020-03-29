package com.exuberant.tutorials.javaconcept.immmutable;

import com.exuberant.tutorials.javaconcept.customObjects.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ImmutableClass {

    private static Logger logger = LoggerFactory.getLogger(ImmutableClass.class);

    static final Employee e = new Employee(1, "Rakesh", "UNR");

    public static void main(String[] args) {
        e.setEmpId(2);
        logger.info(String.valueOf(e));

    }
}