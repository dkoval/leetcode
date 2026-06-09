package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-total-subarray-value-i/">Maximum Total Subarray Value I</a>
 * <p>
 * You are given an integer array nums of length n and an integer k.
 * <p>
 * You need to choose exactly k non-empty subarrays nums[l..r] of nums. Subarrays may overlap, and the exact same subarray (same l and r)
 * can be chosen more than once.
 * <p>
 * The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
 * <p>
 * The total value is the sum of the values of all chosen subarrays.
 * <p>
 * Return the maximum possible total value you can achieve.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == nums.length <= 5 * 10^4</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 *  <li>1 <= k <= 10^5</li>
 * </ul>
 */
public interface MaximumTotalSubarrayValue1 {

    long maxTotalValue(int[] nums, int k);

    class MaximumTotalSubarrayValue1Rev1 implements MaximumTotalSubarrayValue1 {

        @Override
        public long maxTotalValue(int[] nums, int k) {
            var min = Integer.MAX_VALUE;
            var max = Integer.MIN_VALUE;

            for (var x : nums) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }

            return (long) (max - min) * k;
        }
    }
}
