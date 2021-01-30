package com.exuberant.tutorials.javaconcept.json;

public class Wcis {
    String wcisId;
    String name;

    public String getWcisId() {
        return wcisId;
    }

    public void setWcisId(String wcisId) {
        this.wcisId = wcisId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wcis{" +
                "wcisId='" + wcisId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
