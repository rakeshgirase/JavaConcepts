package com.exuberant.tutorials.javaconcept.streams;

import java.util.function.Predicate;

public class EvenPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        return number % 2 != 0;
    }
}
