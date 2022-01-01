package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3564/">Burst Balloons</a>
 * Difficulty: Hard
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 */
public interface BurstBalloons {

    int maxCoins(int[] nums);

    class BurstBalloonsInitial implements BurstBalloons {

        @Override
        public int maxCoins(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }

            int[] balloons = new int[n + 2];
            balloons[0] = 1;
            for (int i = 1; i <= n; i++) {
                balloons[i] = nums[i - 1];
            }
            balloons[n + 1] = 1;

            int[][] dp = new int[n + 1][n + 1];
            for (int left = n; left >= 1; left--) {
                for (int right = left; right <= n; right++) {
                    if (left == right) {
                        // burst left balloon
                        dp[left][right] = balloons[left - 1] * balloons[left] * balloons[left + 1];
                    } else {
                        // p == left
                        dp[left][right] = dp[left + 1][right] + balloons[left - 1] * balloons[left] * balloons[right + 1];
                        // p == right
                        dp[left][right] = Math.max(dp[left][right], dp[left][right - 1] + balloons[left - 1] * balloons[right] * balloons[right + 1]);
                        // left < p < right
                        for (int p = left + 1; p < right; p++) {
                            dp[left][right] = Math.max(dp[left][right], dp[left][p - 1] + dp[p + 1][right] + balloons[p] * balloons[left - 1] * balloons[right + 1]);
                        }
                    }
                }
            }
            return dp[1][n];
        }
    }

    // O(N^3) time | O(N^2) space
    class BurstBalloonsRemastered implements BurstBalloons {

        // Explanation of the algorithm: https://www.youtube.com/watch?v=IFNibRVgFBo
        @Override
        public int maxCoins(int[] nums) {
            int n = nums.length;

            // dp[i][j] - the maximum coins you can collect considering balloons[i:j]
            int[][] dp = new int[n][n];
            // consider all sub-arrays of balloons[i:j] and find the last balloon to burst in the sub-array to maximize the number of collected coins
            for (int len = 1; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    // balloons[k] is the last balloon to burst in balloons[i:j]
                    for (int k = i; k <= j; k++) {
                        int numCoins = (k == i ? 0 : dp[i][k - 1]) // left side: if k = i, there is nothing to the left
                                + (i == 0 ? 1 : nums[i - 1]) * nums[k] * (j == n - 1 ? 1 : nums[j + 1]) // balloon to burst
                                + (k == j ? 0 : dp[k + 1][j]); // right side: if k = j, there is nothing to the right

                        //System.out.printf("Length = %d, sub-array = [%d:%d], last balloon to burst = %d, coins = %d\n", len, i, j, k, numCoins);
                        dp[i][j] = Math.max(dp[i][j], numCoins);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
