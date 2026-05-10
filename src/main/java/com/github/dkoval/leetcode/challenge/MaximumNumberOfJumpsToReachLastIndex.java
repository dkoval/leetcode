package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/">Maximum Number of Jumps to Reach the Last Index</a>
 * <p>
 * You are given a 0-indexed array nums of n integers and an integer target.
 * <p>
 * You are initially positioned at index 0. In one step, you can jump from index i to any index j such that:
 * <p>
 * 0 <= i < j < n
 * -target <= nums[j] - nums[i] <= target
 * Return the maximum number of jumps you can make to reach index n - 1.
 * <p>
 * If there is no way to reach index n - 1, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length == n <= 1000</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 *  <li>0 <= target <= 2 * 10^9</li>
 * </ul>
 */
public interface MaximumNumberOfJumpsToReachLastIndex {

    int maximumJumps(int[] nums, int target);

    // O(n^2) time | O(n) space
    class MaximumNumberOfJumpsToReachLastIndexRev1 implements MaximumNumberOfJumpsToReachLastIndex {

        @Override
        public int maximumJumps(int[] nums, int target) {
            final var n = nums.length;
            final var count = calc(nums, target, 0, new Integer[n]);
            return (count >= 0) ? count : -1;
        }

        // the max number of steps you can make to reach (n - 1) from index
        private int calc(int[] nums, int target, int index, Integer[] dp) {
            final var n = nums.length;

            // base case
            if (index == n - 1) {
                return 0;
            }

            // already solved?
            if (dp[index] != null) {
                return dp[index];
            }

            var count = Integer.MIN_VALUE;
            for (var j = index + 1; j < n; j++) {
                if (Math.abs(nums[j] - nums[index]) <= target) {
                    count = Math.max(count, 1 + calc(nums, target, j, dp));
                }
            }
            return dp[index] = count;
        }
    }

    // O(n^2) time | O(n) space
    class MaximumNumberOfJumpsToReachLastIndexRev2 implements MaximumNumberOfJumpsToReachLastIndex {

        @Override
        public int maximumJumps(int[] nums, int target) {
            final var n = nums.length;

            final var dp = new int[n];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            for (var j = 0; j < n; j++) {
                for (var i = 0; i < j; i++) {
                    if (dp[i] != -1 && Math.abs(nums[j] - nums[i]) <= target) {
                        dp[j] = Math.max(dp[j], 1 + dp[i]);
                    }
                }
            }
            return dp[n - 1];
        }
    }

    class MaximumNumberOfJumpsToReachLastIndexRev3 implements MaximumNumberOfJumpsToReachLastIndex {

        @Override
        public int maximumJumps(int[] nums, int target) {
            final var n = nums.length;

            final var dp = new int[n];
            Arrays.fill(dp, -1);
            dp[n - 1] = 0;

            for (var i = n - 2; i >= 0; i--) {
                for (var j = i + 1; j < n; j++) {
                    if (dp[j] != -1 && Math.abs(nums[j] - nums[i]) <= target) {
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                    }
                }
            }
            return dp[0];
        }
    }
}
