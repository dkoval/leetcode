package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/partition-array-for-maximum-sum/">Partition Array for Maximum Sum</a>
 * <p>
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
 * After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 * <p>
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Constraints:
 * <ul>
 * <li>1 <= arr.length <= 500</li>
 * <li>0 <= arr[i] <= 109</li>
 * <li>1 <= k <= arr.length</li>
 * </ul>
 */
public interface PartitionArrayForMaximumSum {

    int maxSumAfterPartitioning(int[] arr, int k);

    // O(N * K) time | O(N) space
    class PartitionArrayForMaximumSumDPTopDown implements PartitionArrayForMaximumSum {

        @Override
        public int maxSumAfterPartitioning(int[] arr, int k) {
            // DP top-down
            int n = arr.length;
            return calc(arr, k, 0, new Integer[n]);
        }

        private int calc(int[] arr, int k, int index, Integer[] dp) {
            int n = arr.length;

            // base case
            if (index == n) {
                return 0;
            }

            // already solved?
            if (dp[index] != null) {
                return dp[index];
            }

            // starting at `index`, try all possible partitions of length <= k
            int maxVal = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for (int i = index; i < Math.min(index + k, n); i++) {
                maxVal = Math.max(maxVal, arr[i]);
                maxSum = Math.max(maxSum, maxVal * (i - index + 1) + calc(arr, k, i + 1, dp));
            }
            return dp[index] = maxSum;
        }
    }
}
