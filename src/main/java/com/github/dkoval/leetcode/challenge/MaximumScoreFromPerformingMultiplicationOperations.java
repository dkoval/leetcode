package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/">Maximum Score from Performing Multiplication Operations</a>
 * <p>
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 * <p>
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 * <ul>
 *  <li>Choose one integer x from either the start or the end of the array nums.</li>
 *  <li>Add multipliers[i] * x to your score.</li>
 *  <li>Remove x from the array nums.</li>
 * </ul>
 * Return the maximum score after performing m operations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>m == multipliers.length</li>
 *  <li>1 <= m <= 10^3</li>
 *  <li>m <= n <= 10^5</li>
 *  <li>-1000 <= nums[i], multipliers[i] <= 1000</li>
 * </ul>
 */
public interface MaximumScoreFromPerformingMultiplicationOperations {

    int maximumScore(int[] nums, int[] multipliers);

    // Produces Memory Limit Exceeded error
    class MaximumScoreFromPerformingMultiplicationOperationsMLE implements MaximumScoreFromPerformingMultiplicationOperations {

        @Override
        public int maximumScore(int[] nums, int[] multipliers) {
            int n = nums.length;
            return maxScore(nums, 0, n - 1, multipliers, 0, new Integer[n][n]);
        }

        private int maxScore(int[] nums, int start, int end, int[] multipliers, int idx, Integer[][] memo) {
            if (idx == multipliers.length) {
                return 0;
            }

            if (memo[start][end] != null) {
                return memo[start][end];
            }

            int pickFromStart = nums[start] * multipliers[idx] + maxScore(nums, start + 1, end, multipliers, idx + 1, memo);
            int pickFromEnd = nums[end] * multipliers[idx] + maxScore(nums, start, end - 1, multipliers, idx + 1, memo);
            return memo[start][end] = Math.max(pickFromStart, pickFromEnd);
        }
    }

    class MaximumScoreFromPerformingMultiplicationOperationsSpaceOptimized implements MaximumScoreFromPerformingMultiplicationOperations {

        @Override
        public int maximumScore(int[] nums, int[] multipliers) {
            int m = multipliers.length;
            return maxScore(nums, 0, multipliers, 0, new Integer[m][m]);
        }

        private int maxScore(int[] nums, int start, int[] multipliers, int idx, Integer[][] memo) {
            int n = nums.length;
            int m = multipliers.length;

            if (idx == m) {
                return 0;
            }

            if (memo[start][idx] != null) {
                return memo[start][idx];
            }

            int pickFromStart = nums[start] * multipliers[idx] + maxScore(nums, start + 1, multipliers, idx + 1, memo);
            int pickFromEnd = nums[n - (idx - start) - 1] * multipliers[idx] + maxScore(nums, start, multipliers, idx + 1, memo);
            return memo[start][idx] = Math.max(pickFromStart, pickFromEnd);
        }
    }
}
