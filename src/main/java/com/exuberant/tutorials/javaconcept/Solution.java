package com.exuberant.tutorials.javaconcept;

public class Solution {

    public static void main(String[] args) {
        solution(100);
        solution(123);
        solution(10011);
    }

    public static void solutionPartial(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print != 0 && N % 10 == 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
        System.out.println("");
    }

    public static void originalSolution(int number) {
        int enable_print = number % 10;
        while (number > 0) {
            if (enable_print == 0 && number % 10 != 0) {
                enable_print = 1;
            } else if (enable_print == 1) {
                System.out.print(number % 10);
            }
            number = number / 10;
        }
        System.out.print(number);
    }

    public static void solution(int number) {
        int enable_print = number % 10;
        while (number > 0) {
            if (enable_print == 0 && number % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print > 0) {
                System.out.print(number % 10);
            }
            number = number / 10;
            enable_print = enable_print > 0 && number > 0 ? 1 : 0;
        }
        System.out.println("\n");
    }
}