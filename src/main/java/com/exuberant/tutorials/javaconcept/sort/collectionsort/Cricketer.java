package com.exuberant.tutorials.javaconcept.sort.collectionsort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cricketer implements Comparable<Cricketer> {

    private static Logger logger = LoggerFactory.getLogger(Cricketer.class);

    String name = "";
    int avg;
    String teamName = "";

    public Cricketer(String name, int avg, String teamName) {
        super();
        this.name = name;
        this.avg = avg;
        this.teamName = teamName;
    }

    public static void main(String[] arg) {
        int[] a = {5, 874, 45, 3, 988, 4, 215};
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        logger.info("min is [{}]", min);
    }

    @Override
    public int compareTo(Cricketer obj) {
        if (this.avg > obj.avg) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name + avg + teamName;
    }

    @Override
    public void finalize() {
        logger.info("Finalize has run for: [{}]", this);
    }
}
