package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-average-difference/">Minimum Average Difference</a>
 * <p>
 * You are given a 0-indexed integer array nums of length n.
 * <p>
 * The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums
 * and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.
 * <p>
 * Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
 * <p>
 * Note:
 * <ul>
 *  <li>The absolute difference of two numbers is the absolute value of their difference.</li>
 *  <li>The average of n elements is the sum of the n elements divided (integer division) by n.</li>
 *  <li>The average of 0 elements is considered to be 0.</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  li>0 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface MinimumAverageDifference {

    int minimumAverageDifference(int[] nums);

    // O(N) time | O(N) space
    class MinimumAverageDifferenceRev1 implements MinimumAverageDifference {

        @Override
        public int minimumAverageDifference(int[] nums) {
            int n = nums.length;

            // sum[i] = nums[0] + ... + nums[i]
            long[] sum = new long[n];
            sum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }

            long best = Long.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < n; i++) {
                long firstAvg = sum[i] / (i + 1);
                long lastAvg = (i < n - 1) ? (sum[n - 1] - sum[i]) / (n - i - 1) : 0;

                long diff = Math.abs(firstAvg - lastAvg);
                if (diff < best) {
                    best = diff;
                    idx = i;
                }
            }
            return idx;
        }
    }
}
