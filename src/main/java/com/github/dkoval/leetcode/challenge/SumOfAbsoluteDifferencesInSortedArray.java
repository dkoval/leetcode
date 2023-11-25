package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/">Sum of Absolute Differences in a Sorted Array</a>
 * <p>
 * You are given an integer array nums sorted in non-decreasing order.
 * <p>
 * Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of
 * absolute differences between nums[i] and all the other elements in the array.
 * <p>
 * In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= nums[i + 1] <= 10^4</li>
 * </ul>
 */
public interface SumOfAbsoluteDifferencesInSortedArray {

    int[] getSumAbsoluteDifferences(int[] nums);

    // O(N) time | O(M_ space
    class SumOfAbsoluteDifferencesInSortedArrayRev1 implements SumOfAbsoluteDifferencesInSortedArray {

        @Override
        public int[] getSumAbsoluteDifferences(int[] nums) {
            int n = nums.length;

            // ans[i] = (nums[i] - nums[0]) + (nums[i] - nums[1]) + ... + (nums[i] - nums[i - 1]) +
            // + (nums[i + 1] - nums[i]) + (nums[i + 2] - nums[i]) + ... + (nums[n - 1] - nums[i]) =
            // = nums[i] * i - (nums[0] + nums[1] + ... + nums[i - 1]) - nums[i] * (n - i - 1) + (nums[i + 1] + nums[i + 2] + ... + nums[n - 1]) =
            // = nums[i] * (2 * i - n + 1) - (nums[0] + nums[1] + ... + nums[i - 1]) + (nums[i + 1] + nums[i + 2] + ... + nums[n - 1])

            // prefixSum[i] = nums[0] + nums[1] + ... + nums[i]
            // suffixSum[i] = nums[i] + nums[i + 1] + ... + nums[n - 1] = prefixSum[n - 1] - prefixSum[i - 1]
            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = nums[i] * (2 * i - n + 1);
                ans[i] -= (i > 0) ? prefixSum[i - 1] : 0;
                ans[i] += prefixSum[n - 1] - prefixSum[i];
            }
            return ans;
        }
    }
}
