package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3698/">Minimum Operations to Make Array Equal</a>
 * <p>
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
 * <p>
 * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y]
 * (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal.
 * It is guaranteed that all the elements of the array can be made equal using some operations.
 * <p>
 * Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.
 * <p>
 * Constraints: 1 <= n <= 10^4
 */
public class MinimumOperationsToMakeArrayEqual {

    // O(1) time | O(1) space
    public int minOperations(int n) {
        // case #1: n is odd
        // [1  3  5  7  9], target = 5
        //  ^  ^  #  ^  ^
        //  |  |  |  |  |
        // +4 +2  | -2 -4
        //  |  |  |  |  |
        // [5  5  5  5  5]
        // ---
        // answer = 2 + 4 = 2 * (1 + 2) = 2 * (1 + 2 + ... + k) = 2 * k * (k + 1) / 2 = k * (k + 1), where k = n / 2

        // case #2: n is odd
        // [1  3  5  7  9  11], target = (5 + 7) / 2 = 6
        //  ^  ^  #  #  ^  ^
        //  |  |  |  |  |  |
        // +5 +3 +1 -1 -3 -5
        //  |  |  |  |  |  |
        // [6  6  6  6  6  6]
        // ---
        // answer = 1 + 3 + 5 = 1 + 3 + ... + 2 * k - 1 = k^2, where k = n / 2
        int k = n / 2;
        return (n % 2 == 0) ? k * k : k * (k + 1);
    }
}
