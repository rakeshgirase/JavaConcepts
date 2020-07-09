package com.exuberant.tutorials.javaconcept.interviews;

public class LongestUniqueSubStringFinder {

    public static String findLongestUniqueSubstring(String string) {
        String temp = null;
        String max = null;
        for (int i = 0; i < string.length(); i++) {
            temp = String.valueOf(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                char character = string.charAt(j);
                if (temp.indexOf(character) == -1) {
                    temp = temp + character;
                } else {
                    break;
                }
            }
            if (max == null || max.length() < temp.length()) {
                max = temp;
            }
            if (max.length() > string.length() / 2) {
                break;
            }
        }

        return max;

    }
}
