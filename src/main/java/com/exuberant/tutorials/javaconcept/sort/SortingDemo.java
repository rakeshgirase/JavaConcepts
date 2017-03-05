package com.exuberant.tutorials.javaconcept.sort;

public class SortingDemo {
    public static void main(String[] args) {

    }

    public static void insertion(int array[], int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            int b = array[i];
            while ((j > 0) && (array[j - 1] > b)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = b;
        }
    }

    public static void bubble(int a[], int n) {
        int i, j, t = 0;
        for (i = 0; i < n; i++) {
            for (j = 1; j < (n - i); j++) {
                if (a[j - 1] > a[j]) {
                    t = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = t;
                }
            }
        }
    }
}
