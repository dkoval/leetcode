package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-ascending-subarray-sum/">Maximum Ascending Subarray Sum</a>
 * <p>
 * Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
 * <p>
 * A subarray is defined as a contiguous sequence of numbers in an array.
 * <p>
 * A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1.
 * Note that a subarray of size 1 is ascending.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface MaximumAscendingSubarraySum {

    int maxAscendingSum(int[] nums);

    class MaximumAscendingSubarraySumRev1 implements MaximumAscendingSubarraySum {

        @Override
        public int maxAscendingSum(int[] nums) {
            final var n = nums.length;

            var sum = nums[0];
            var best = nums[0];
            for (var i = 1; i < n; i++) {
                if (nums[i - 1] < nums[i]) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
                best = Math.max(best, sum);
            }
            return best;
        }
    }
}
