package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximize-score-after-n-operations/">Maximize Score After N Operations (Hard)</a>
 * <p>
 * You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.
 * <p>
 * In the ith operation (1-indexed), you will:
 * <ul>
 *  <li>Choose two elements, x and y.</li>
 *  <li>Receive a score of i * gcd(x, y).</li>
 *  <li>Remove x and y from nums.</li>
 * </ul>
 * Return the maximum score you can receive after performing n operations.
 * <p>
 * The function gcd(x, y) is the greatest common divisor of x and y.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 7</li>
 *  <li>nums.length == 2 * n</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 * </ul>
 */
public interface MaximizeScoreAfterNOperations {

    int maxScore(int[] nums);

    class MaximizeScoreAfterNOperationsDPTopDown implements MaximizeScoreAfterNOperations {

        @Override
        public int maxScore(int[] nums) {
            // idea: DP top-down + bit mask to keep track of used numbers
            int n = nums.length;
            Integer[] dp = new Integer[1 << n];
            return calculate(nums, 0, 1, dp);
        }

        private int calculate(int[] nums, int mask, int iteration, Integer[] dp) {
            // already solved?
            if (dp[mask] != null) {
                return dp[mask];
            }

            int n = nums.length;

            // generate pairs of unused numbers
            int best = 0;
            for (int i = 0; i < n - 1; i++) {
                // can use index i?
                if ((mask & (1 << i)) == 0) {
                    for (int j = i + 1; j < n; j++) {
                        // can use index j?
                        if ((mask & (1 << j)) == 0) {
                            int score = iteration * gcd(nums[i], nums[j]);
                            score += calculate(nums, mask | (1 << i) | (1 << j), iteration + 1, dp);
                            best = Math.max(best, score);
                        }
                    }
                }
            }
            return dp[mask] = best;
        }

        private int gcd(int x, int y) {
            if (y == 0) {
                return x;
            }
            return gcd(y, x % y);
        }
    }
}
