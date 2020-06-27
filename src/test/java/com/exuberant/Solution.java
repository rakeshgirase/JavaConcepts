package com.exuberant;

import org.junit.Test;

public class Solution {
    public void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (false) {
                enable_print = 1;
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
            System.out.print('\n');
        }
    }

    @Test
    public void test(){
        solution(123);
        solution(654684964);
        solution(221221);
        solution(64648468);
    }
}