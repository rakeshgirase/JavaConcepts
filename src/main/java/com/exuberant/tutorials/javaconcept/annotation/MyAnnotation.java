package com.exuberant.tutorials.javaconcept.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.})//This tells On what element annotation can be applied
public @interface MyAnnotation {
    String name();

    String lastName();
}