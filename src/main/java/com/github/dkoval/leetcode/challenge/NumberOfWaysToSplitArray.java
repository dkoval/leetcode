package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-split-array/">Number of Ways to Split Array</a>
 * <p>
 * You are given a 0-indexed integer array nums of length n.
 * <p>
 * nums contains a valid split at index i if the following are true:
 * <ul>
 *  <li>The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.</li>
 *  <li>There is at least one element to the right of i. That is, 0 <= i < n - 1.</li>
 * </ul>
 * Return the number of valid splits in nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>-10^5 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface NumberOfWaysToSplitArray {

    int waysToSplitArray(int[] nums);

    // O(N) time | O(N) space
    class NumberOfWaysToSplitArrayRev1 implements NumberOfWaysToSplitArray {

        @Override
        public int waysToSplitArray(int[] nums) {
            final var n = nums.length;

            // prefixSum[i] = nums[0] + nums[1] + ... + nums[i - 1];
            final var prefixSum = new long[n];
            prefixSum[0] = nums[0];
            for (var i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }

            var count = 0;
            for (var i = 0; i < n - 1; i++) {
                if (prefixSum[i] >= prefixSum[n - 1] - prefixSum[i]) {
                    count++;
                }
            }
            return count;
        }
    }
}
