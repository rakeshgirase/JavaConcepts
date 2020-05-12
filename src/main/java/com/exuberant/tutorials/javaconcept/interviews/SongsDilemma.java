package com.exuberant.tutorials.javaconcept.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.awt.HKSCS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SongsDilemma {

    private static Logger logger = LoggerFactory.getLogger(SongsDilemma.class);

    public int getCount(List<Integer> songs) {
        int count = 0;
        Set<Pair> alreadyUsed = new HashSet<>();
        for (int first = 0; first < songs.size(); first++) {
            for (int second = 0; second < songs.size(); second++) {
                Pair current = new Pair(first, second);
                if (first != second && !alreadyUsed.contains(current)) {
                    if ((songs.get(first) + songs.get(second)) % 60 == 0) {
                        logger.info("Adding Pair: {}, {}, {}", current, songs.get(first), songs.get(second));
                        count += 1;
                        alreadyUsed.add(current);
                    }
                }
            }
        }
        logger.info("Matched Pairs: {}", alreadyUsed);
        return count;
    }
}

class Pair {
    private static Logger logger = LoggerFactory.getLogger(Pair.class);
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        logger.info("Called Equals: this: {}, that: {}", this, o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;
        return (first == pair.first && second == pair.second) || (first == pair.second && second == pair.first);
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result * second;
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
