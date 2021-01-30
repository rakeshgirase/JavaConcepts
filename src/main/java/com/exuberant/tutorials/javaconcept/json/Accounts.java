package com.exuberant.tutorials.javaconcept.json;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    List<Wcis> wcis = new ArrayList<>();

    public List<Wcis> getWcis() {
        return wcis;
    }

    public void setWcis(List<Wcis> wcis) {
        this.wcis = wcis;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "wcis=" + wcis +
                '}';
    }
}
