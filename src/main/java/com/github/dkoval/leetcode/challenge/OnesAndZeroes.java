package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3694/">Ones and Zeroes</a>
 * <p>
 * You are given an array of binary strings strs and two integers m and n.
 * <p>
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * <p>
 * A set x is a subset of a set y if all elements of x are also elements of y.
 */
public class OnesAndZeroes {

    // O(L * M * N) time | O(M * N) space
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] - best result given i 0s and j 1s
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = countZerosAndOnes(str);
            for (int zero = m; zero >= count[0]; zero--) {
                for (int one = n; one >= count[1]; one--) {
                    // case #1: accept str
                    int accept = 1 + dp[zero - count[0]][one - count[1]];
                    // case #2: reject str
                    int reject = dp[zero][one];
                    dp[zero][one] = Math.max(accept, reject);
                }
            }
        }
        return dp[m][n];
    }

    private int[] countZerosAndOnes(String str) {
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count[c - '0']++;
        }
        return count;
    }
}
