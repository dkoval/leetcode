package com.github.dkoval.leetcode.problems;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/">Range Sum of Sorted Subarray Sums</a>
 * <p>
 * You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous subarrays
 * from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.
 * <p>
 * Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array.
 * Since the answer can be a huge number return it modulo 109 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 100</li>
 *  <li>1 <= left <= right <= n * (n + 1) / 2</li>
 * </ul>
 */
public interface RangeSumOfSortedSubarraySums {

    int rangeSum(int[] nums, int n, int left, int right);

    // O(N^2) time | O(N^2) space
    class RangeSumOfSortedSubarraySumsNaive implements RangeSumOfSortedSubarraySums {

        private static final int MOD = 1000_000_007;

        @Override
        public int rangeSum(int[] nums, int n, int left, int right) {
            int idx = 0;
            int[] sums = new int[n * (n + 1) / 2];

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    sums[idx] = nums[j] + (j > i ? sums[idx - 1] : 0);
                    sums[idx] %= MOD;
                    idx++;
                }
            }

            Arrays.sort(sums);

            int ans = 0;
            for (int i = left - 1; i < right; i++) {
                ans += sums[i];
                ans %= MOD;
            }
            return ans;
        }
    }
}
