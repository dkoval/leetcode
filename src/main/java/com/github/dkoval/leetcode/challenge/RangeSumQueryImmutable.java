package com.github.dkoval.leetcode.challenge;

/**
 * <a href = "https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3892/">Range Sum Query - Immutable</a>
 * <p>
 * Given an integer array nums, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * <p>
 * Implement the NumArray class:
 * <ul>
 *  <li>NumArray(int[] nums) Initializes the object with the integer array nums.</li>
 *  <li>int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).</li>
 * </ul>
 */
public abstract class RangeSumQueryImmutable {

    public static class NumArray {
        // prefixSum[i + 1] stores the sum nums[0] + nums[1] + ... + nums[i]
        // prefixSum[0] = 0, index i is in range [0 : n - 1]
        private final int[] prefixSum;

        public NumArray(int[] nums) {
            this.prefixSum = prefixSum(nums);
        }

        private int[] prefixSum(int[] nums) {
            int n = nums.length;
            int[] prefixSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
            return prefixSum;
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }
}
