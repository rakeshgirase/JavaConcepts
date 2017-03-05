package com.exuberant.tutorials.javaconcept.stacks;

import java.util.ArrayList;
import java.util.Random;

public class StackTest {
    public static void main(String[] args) {
        int min = 101;
        Random r = new Random();
        ArrayList<Integer> minColl = new ArrayList<Integer>();
        System.out.println("=============Populating Stack===================");
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(100);
            System.out.println(num);
            if (min > num) {
                min = num;
                minColl.add(min);
            }
            Stack.push(num);
        }
        System.out.println("=============Elements in The Stack Top Down===================");
        Stack.printStack();
        System.out.println("===============Removed Elements=================");
        for (int i = 0; i < 5; i++) {
            int removed = Stack.pop();
            if (removed == minColl.get(minColl.size() - 1)) {
                minColl.remove(minColl.size() - 1);
            }
            System.out.println(removed + " New Min Is "
                    + minColl.get(minColl.size() - 1));
        }
    }
}