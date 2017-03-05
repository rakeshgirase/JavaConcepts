package com.exuberant.tutorials.javaconcept.generics;


public class GenericWildCardOperator {


    public GenericWildCardOperator() {

    }

    public static void main(String[] args) {
        String s1 = "rakesh";
        String s2 = "rakesh";
        Name s3 = new Name();
        s3.setName("rakesh");
        Name s4 = new Name();
        s4.setName("rakesh");
        System.out.println("rakesh" == "rakesh");
        System.out.println("rakesh" == s2);
        System.out.println(s1 == s2);
        System.out.println(s3.getName() == s4.getName());
    }
}

class Name {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
