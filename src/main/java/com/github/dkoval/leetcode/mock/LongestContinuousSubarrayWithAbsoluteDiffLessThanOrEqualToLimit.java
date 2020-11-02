package com.github.dkoval.leetcode.mock;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/">Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit</a>
 * <p>
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray
 * such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 */
public abstract class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public abstract int longestSubarray(int[] nums, int limit);

    public static class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitBruteForce
            extends LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

        // Time complexity: (N^2) - TLE
        // Space complexity: O(1)
        @Override
        public int longestSubarray(int[] nums, int limit) {
            int maxLen = 0;
            for (int start = 0; start < nums.length; start++) {
                int minNum = Integer.MAX_VALUE;
                int maxNum = Integer.MIN_VALUE;
                for (int end = start; end < nums.length; end++) {
                    minNum = Math.min(minNum, nums[end]);
                    maxNum = Math.max(maxNum, nums[end]);
                    if (maxNum - minNum <= limit) {
                        maxLen = Math.max(maxLen, end - start + 1);
                    }
                }
            }
            return maxLen;
        }
    }

    public static class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitUsingMinMaxDeques
            extends LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

        // Time complexity: O(N)
        // Space complexity: O(N)
        @Override
        public int longestSubarray(int[] nums, int limit) {
            int maxLen = 0;
            int start = 0;
            Deque<Integer> minQ = new ArrayDeque<>(); // increasing queue, recording 1st, 2nd, ..., smallest numbers between [start:end]
            Deque<Integer> maxQ = new ArrayDeque<>(); // decreasing queue, recording 1st, 2nd, ..., biggest numbers between [start:end]
            for (int end = 0; end < nums.length; end++) {
                while (!minQ.isEmpty() && minQ.peekLast() > nums[end]) {
                    minQ.removeLast();
                }
                minQ.addLast(nums[end]);

                while (!maxQ.isEmpty() && maxQ.peekLast() < nums[end]) {
                    maxQ.removeLast();
                }
                maxQ.addLast(nums[end]);

                if (maxQ.peekFirst() - minQ.peekFirst() <= limit) {
                    maxLen = Math.max(maxLen, end - start + 1);
                } else {
                    if (minQ.peekFirst() == nums[start]) {
                        minQ.removeFirst();
                    }
                    if (maxQ.peekFirst() == nums[start]) {
                        maxQ.removeFirst();
                    }
                    start++;
                }
            }
            return maxLen;
        }
    }
}
