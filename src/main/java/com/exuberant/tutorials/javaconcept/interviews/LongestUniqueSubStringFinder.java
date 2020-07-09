package com.exuberant.tutorials.javaconcept.interviews;

public class LongestUniqueSubStringFinder {

    public static String findLongestUniqueSubstring(String string) {
        String temp = null;
        String max = null;
        for (int i = 0; i < string.length(); i++) {
            temp = "" + string.charAt(i);
            for (int j = i + 1; j < string.length(); j++) {
                char character = string.charAt(j);
                if (temp.contains(String.valueOf(character))) {
                    break;
                } else {
                    temp = temp + character;
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
