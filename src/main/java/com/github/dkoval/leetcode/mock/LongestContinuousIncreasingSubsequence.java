package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/longest-continuous-increasing-subsequence/">Longest Continuous Increasing Subsequence</a>
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray).
 * The subsequence must be strictly increasing.
 * <p>
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is
 * [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1]
 */
public abstract class LongestContinuousIncreasingSubsequence {

    public abstract int findLengthOfLCIS(int[] nums);

    // O(N^2) time | O(1) space
    public static class LongestContinuousIncreasingSubsequenceBruteForce extends LongestContinuousIncreasingSubsequence {

        @Override
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int maxLength = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                int length = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[j - 1]) {
                        length++;
                    } else {
                        break;
                    }
                }
                maxLength = Math.max(maxLength, length);
            }
            return maxLength;
        }
    }

    // O(N) time | O(1) time
    public static class LongestContinuousIncreasingSubsequenceSlidingWindow extends LongestContinuousIncreasingSubsequence {

        @Override
        public int findLengthOfLCIS(int[] nums) {
            int maxLength = 0;
            int start = 0;
            for (int end = 0; end < nums.length; end++) {
                if (end > 0 && nums[end - 1] >= nums[end]) {
                    start = end; // reset start of the sliding window
                }
                maxLength = Math.max(maxLength, end - start + 1);
            }
            return maxLength;
        }
    }
}
