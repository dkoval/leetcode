package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/">Minimum Value to Get Positive Step by Step Sum</a>
 * <p>
 * Given an array of integers nums, you start with an initial positive value startValue.
 * <p>
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
 * <p>
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>-100 <= nums[i] <= 100</li>
 * </ul>
 */
public class MinimumValueToGetPositiveStepByStepSum {

    // O(N) time | O(1) space
    public int minStartValue(int[] nums) {
        int ans = 1;
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (sum < 0) {
                ans = Math.max(ans, 1 - sum);
            }
        }
        return ans;
    }
}
