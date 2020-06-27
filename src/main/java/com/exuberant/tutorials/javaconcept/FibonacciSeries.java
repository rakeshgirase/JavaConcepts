package com.exuberant.tutorials.javaconcept;

public class FibonacciSeries {
    public static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
    }

    public static void main(String args[]) {
        System.err.println("Avatar".substring(1,4));
        int maxNumber = 10;
        for (int i = 0; i < maxNumber; i++) {
            System.out.print(fibonacciRecursion(i) + " ");
        }
        System.out.println("\n---------------");
        fibonacciNonRecursion(5);
        System.out.println("\n---------------");
        fibonacciNonRecursion(1);
        System.out.println("\n---------------");
        fibonacciNonRecursion(2);
        System.out.println("\n---------------");
        fibonacciNonRecursion(-2);
        System.out.println("\n---------------");
    }

    public static void fibonacciNonRecursion(int n) {
        if (n > 0) {
            int first = 1;
            int second = 1;
            int temp = 0;
            if (n >= 1) {
                System.out.print(first + " ");
            }
            if (n >= 2) {
                System.out.print(second + " ");
            }
            for (int i = 2; i < n; i++) {
                int next = first + second;
                System.out.print(next + " ");
                temp = second;
                second = next;
                first = temp;
            }
        } else {
            System.out.println("Invalid Number Received!");
        }

    }
}