package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-partitions-with-even-sum-difference/">Count Partitions with Even Sum Difference</a>
 * <p>
 * You are given an integer array nums of length n.
 * <p>
 * A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:
 * <ul>
 *  <li>Left subarray contains indices [0, i].</li>
 *  <li>Right subarray contains indices [i + 1, n - 1].</li>
 * </ul>
 * Return the number of partitions where the difference between the sum of the left and right subarrays is even.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n == nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface CountPartitionsWithEvenSumDifference {

    int countPartitions(int[] nums);

    class CountPartitionsWithEvenSumDifferenceRev1 implements CountPartitionsWithEvenSumDifference {

        @Override
        public int countPartitions(int[] nums) {
            final var n = nums.length;

            final var prefixSum = new int[n];
            prefixSum[0] = nums[0];
            for (var i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }

            var count = 0;
            for (var i = 0; i < n - 1; i++) {
                final var diff = prefixSum[i] - (prefixSum[n - 1] - prefixSum[i]);
                count += (Math.abs(diff % 2) == 0) ? 1 : 0;
            }
            return count;
        }
    }
}
