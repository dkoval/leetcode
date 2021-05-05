package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3732/">Jump Game II</a>
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>0 <= nums[i] <= 10^5</li>
 * </ul>
 */
public class JumpGame2 {

    // O(N) time | O(N) space
    public int jump(int[] nums) {
        int n = nums.length;

        // dp[i] - min number of jumps required to reach the last index starting from i
        int[] dp = new int[n];
        Arrays.fill(dp, 0, n, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int l = 1; l <= nums[i] && i + l < n; l++) {
                dp[i] = Math.min(dp[i], dp[i + l]);
            }
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i]++;
            }
        }
        return dp[0];
    }
}
