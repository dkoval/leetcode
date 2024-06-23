package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/">Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit</a>
 * <p>
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that
 * the absolute difference between any two elements of this subarray is less than or equal to limit.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 *  <li>0 <= limit <= 10^9</li>
 * </ul>
 */
public interface LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    int longestSubarray(int[] nums, int limit);

    class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitRev1 implements LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

        @Override
        public int longestSubarray(int[] nums, int limit) {
            int n = nums.length;

            // sliding window
            Deque<IndexedValue> decreasing = new ArrayDeque<>(); // aims at maintaining the local max
            Deque<IndexedValue> increasing = new ArrayDeque<>(); // aims at maintaining the local min
            int best = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                IndexedValue curr = new IndexedValue(right, nums[right]);

                // update max
                while (!decreasing.isEmpty() && curr.value > decreasing.peekLast().value) {
                    decreasing.pollLast();
                }
                decreasing.offerLast(curr);

                // update min
                while (!increasing.isEmpty() && curr.value < increasing.peekLast().value) {
                    increasing.pollLast();
                }
                increasing.offerLast(curr);

                // maintain window invariant: max - min <= limit
                while (decreasing.peekFirst().value - increasing.peekFirst().value > limit) {
                    while (decreasing.peekFirst().index <= left) {
                        decreasing.pollFirst();
                    }
                    while (increasing.peekFirst().index <= left) {
                        increasing.pollFirst();
                    }
                    left++;
                }
                best = Math.max(best, right - left + 1);
            }
            return best;
        }

        private record IndexedValue(int index, int value) {
        }
    }
}
