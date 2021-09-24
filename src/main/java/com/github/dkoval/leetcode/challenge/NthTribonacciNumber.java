package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3986/">N-th Tribonacci Number</a>
 * <p>
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 */
public class NthTribonacciNumber {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        int[] t = {0, 1, 1};
        for (int i = 3; i <= n; i++) {
            int sum = t[0] + t[1] + t[2];
            t[0] = t[1];
            t[1] = t[2];
            t[2] = sum;
        }
        return t[2];
    }
}
