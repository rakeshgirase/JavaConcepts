package com.exuberant.tutorials.javaconcept.interviews;

public class StringCounter implements Comparable<StringCounter> {
    String name;
    Integer count = 1;

    public StringCounter(String name) {
        super();
        this.name = name;
    }

    public StringCounter(String name, Integer count) {
        super();
        this.name = name;
        this.count = count;
    }

    public void increment() {
        ++count;
    }

    @Override
    public String toString() {
        return "StringCounter [name=" + name + ", count=" + count + "]";
    }

    @Override
    public int compareTo(StringCounter sc) {
        System.out.println("CompareTo Called");
        if (this.name.equals(sc.name)) {
            return 0;
        }
        if (this.count > sc.count) {
            return -1;
        } else if (this.count < sc.count) {
            return 1;
        }
        return 1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Equals Called");
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringCounter other = (StringCounter) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
