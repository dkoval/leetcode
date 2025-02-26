package com.github.dkoval.leetcode.challenge;


/**
 * <a href="https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/">Maximum Absolute Sum of Any Subarray</a>
 * <p>
 * You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
 * <p>
 * Return the maximum absolute sum of any (possibly empty) subarray of nums.
 * <p>
 * Note that abs(x) is defined as follows:
 * <ul>
 *  <li>If x is a negative integer, then abs(x) = -x.</li>
 *  <li>If x is a non-negative integer, then abs(x) = x.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-104 <= nums[i] <= 10^4</li>
 * </ul>
 */
public interface MaximumAbsoluteSumOfAnySubarray {

    int maxAbsoluteSum(int[] nums);

    class MaximumAbsoluteSumOfAnySubarrayRev1 implements MaximumAbsoluteSumOfAnySubarray {

        @Override
        public int maxAbsoluteSum(int[] nums) {
            // idea: variation of Kadane's algorithm
            var maxSum = 0;
            var minSum = 0;
            var maxAbsSum = 0;
            for (var num : nums) {
                maxSum = Math.max(num, maxSum + num);
                minSum = Math.min(num, minSum + num);
                // choose the best option
                maxAbsSum = Math.max(maxAbsSum, Math.abs(maxSum));
                maxAbsSum = Math.max(maxAbsSum, Math.abs(minSum));
            }
            return maxAbsSum;
        }
    }
}
