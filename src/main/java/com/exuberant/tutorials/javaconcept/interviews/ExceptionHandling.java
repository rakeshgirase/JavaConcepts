package com.exuberant.tutorials.javaconcept.interviews;

public class ExceptionHandling {
    public static void main(String[] args) {
        System.out.println(name());
    }

    @SuppressWarnings("finally")
    public static boolean name() {
        try {
            //return true;
            System.exit(0);
            throw new Exception();
        } catch (Exception e) {
            return true;
        } finally {
            //Value in Finally will be returned
            return false;
        }
    }
}
