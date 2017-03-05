package com.exuberant.tutorials.javaconcept.stacks;

import java.util.ArrayList;

public class Stack {
    private static ArrayList<Integer> a = new ArrayList<>();

    private Stack() {
    }

    public static synchronized void push(Integer i) {
        a.add(i);
    }

    public static synchronized int pop() {
        return a.remove(a.size() - 1);
    }

    public static void printStack() {
        int size = a.size();
        for (int i = size - 1; i >= 0; --i) {
            System.out.println(" " + a.get(i));
        }
    }
}
