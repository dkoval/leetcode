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
public class BurstBalloons {

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
