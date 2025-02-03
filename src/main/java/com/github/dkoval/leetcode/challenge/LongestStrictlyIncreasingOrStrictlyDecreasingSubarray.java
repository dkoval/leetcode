package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/">Longest Strictly Increasing or Strictly Decreasing Subarray</a>
 * <p>
 * You are given an array of integers nums. Return the length of the longest subarray of nums which is
 * either strictly increasing or strictly decreasing.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 50</li>
 *  <li>1 <= nums[i] <= 50</li>
 * </ul>
 */
public interface LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    int longestMonotonicSubarray(int[] nums);

    class LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayRev1 implements LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

        @Override
        public int longestMonotonicSubarray(int[] nums) {
            // n >= 1
            final var n = nums.length;

            // Possible states:
            // -1 : decreasing
            // 0  : unknown
            // 1  : increasing
            var dx = 0;
            var length = 1;
            var best = 1;
            for (var i = 1; i < n; i++) {
                if (nums[i - 1] < nums[i]) {
                    if (dx > 0) {
                        length++;
                    } else {
                        length = 2;
                        dx = 1;
                    }
                } else if (nums[i - 1] > nums[i]) {
                    if (dx < 0) {
                        length++;
                    } else {
                        length = 2;
                        dx = -1;
                    }
                } else {
                    length = 1;
                    dx = 0;
                }
                best = Math.max(best, length);
            }
            return best;
        }
    }
}
