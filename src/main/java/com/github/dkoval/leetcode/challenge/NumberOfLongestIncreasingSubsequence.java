package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3513/">Number of Longest Increasing Subsequence</a>
 * <p>
 * Given an integer array nums, return the number of longest increasing subsequences.
 */
public class NumberOfLongestIncreasingSubsequence {

    // Time complexity: O(N^2)
    // Space complexity: O(N)
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // lengths[i] - length of LIS ending at index i (DP array)
        int[] lengths = new int[nums.length];
        // counts[i] - number of LISs ending at index i
        int[] counts = new int[nums.length];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        int lisLength = 1;
        for (int j = 1; j < nums.length; j++) {
            // look all elements before nums[j]
            for (int i = 0; i < j; i++) {
                // can we extend subsequence?
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        // append nums[j] to a subsequence ending at index i
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        // special case
                        counts[j] += counts[i];
                    }
                }
                lisLength = Math.max(lisLength, lengths[j]);
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lengths[i] == lisLength) {
                count += counts[i];
            }
        }
        return count;
    }
}
