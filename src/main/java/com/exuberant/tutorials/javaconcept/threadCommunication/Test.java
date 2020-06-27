package com.exuberant.tutorials.javaconcept.threadCommunication;

import java.util.LinkedHashSet;

public class Test {

    public static void main(String[] args) {
        System.err.println(removeDuplicates("Rakaesah"));
        System.err.println(removeDuplicates("goodmorning"));
        System.err.println(removeDuplicatesOld("Rakaesah"));
    }

    public static String removeDuplicatesOld(String string){
        LinkedHashSet<Character> characters = new LinkedHashSet<>();
        for (Character character : string.toCharArray()) {
            characters.add(character);
        }

        return characters.toString();
    }

    public static String removeDuplicates(String string){
        StringBuilder sb = new StringBuilder();
        string.chars().distinct().forEach(c -> sb.append((char) c));
        return sb.toString();
    }
}
