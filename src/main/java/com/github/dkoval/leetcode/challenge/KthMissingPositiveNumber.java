package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3594/">Kth Missing Positive Number</a>
 * <p>
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * <p>
 * Find the kth positive integer that is missing from this array.
 */
public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int remaining = k;
        if (arr[0] > 1) {
            remaining -= arr[0] - 1;
        }
        if (remaining <= 0) {
            return k;
        }
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            int currMissing = arr[i] - prev - 1;
            if (currMissing >= remaining) {
                return prev + remaining;
            }
            remaining -= currMissing;
            prev = arr[i];
        }
        return arr[n - 1] + remaining;
    }
}
