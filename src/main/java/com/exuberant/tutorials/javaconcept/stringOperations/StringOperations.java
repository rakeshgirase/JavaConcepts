package com.exuberant.tutorials.javaconcept.stringOperations;

public class StringOperations {
    public static void main(String[] args) {
        String duplicate = new String("Rakesh");
        String name = "Rakesha";
        if (name == duplicate) {
            System.out.println("Equals");
        } else {
            System.out.println("Difference");
        }
        StringBuffer buff = new StringBuffer("Rakesh");
        System.out.println(buff);
        System.err.println(reverse(name));


    }

    public static String reverse(String reverse) {
        int size = reverse.length();
        char[] word = new char[10];
        int mid = size / 2;
        word = reverse.toCharArray();
        for (int i = (mid - 1), j = (mid + 1); i >= 0 && j < size; i--, j++) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
        }
        return new String(word);
    }
}
