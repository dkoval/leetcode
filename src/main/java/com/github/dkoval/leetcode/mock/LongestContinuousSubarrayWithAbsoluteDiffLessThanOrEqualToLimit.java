package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/">Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit</a>
 * <p>
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray
 * such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    // Time complexity: (N^2) - TLE
    // Space complexity: O(1)
    public int longestSubarray(int[] nums, int limit) {
        int longestSubArraySize = 0;
        for (int i = 0; i < nums.length; i++) {
            int minNum = Integer.MAX_VALUE;
            int maxNum = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                minNum = Math.min(minNum, nums[j]);
                maxNum = Math.max(maxNum, nums[j]);
                if (Math.abs(maxNum - minNum) <= limit) {
                    longestSubArraySize = Math.max(longestSubArraySize, j - i + 1);
                }
            }
        }
        return longestSubArraySize;
    }
}
