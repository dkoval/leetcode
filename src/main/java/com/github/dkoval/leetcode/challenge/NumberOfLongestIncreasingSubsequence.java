package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3513/">Number of Longest Increasing Subsequence</a>
 * <p>
 * Given an integer array nums, return the number of longest increasing subsequences.
 */
public class NumberOfLongestIncreasingSubsequence {

    // Time complexity: O(N^2)
    // Space complexity: O(N)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        // lis[i] - the length of LIS starting at index i
        int[] lis = new int[n];
        // count[i] - number of LIS' starting at index i
        int[] count = new int[n];

        int bestLength = 1;
        for (int i = n - 1; i >= 0; i--) {
            // nums[i] is a LIS of length 1
            lis[i] = 1;
            count[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    // extend count[j] subsequences starting at index j by prepending nums[i] to all of them
                    if (lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                    } else if (lis[i] == lis[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            bestLength = Math.max(bestLength, lis[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] == bestLength) {
                total += count[i];
            }
        }
        return total;
    }
}
