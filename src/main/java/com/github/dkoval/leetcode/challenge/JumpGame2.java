package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">Jump Game II</a>
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i],
 * you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^4</li>
 *  <li>0 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface JumpGame2 {

    int jump(int[] nums);

    class JumpGame2Rev1 implements JumpGame2 {

        @Override
        public int jump(int[] nums) {
            int n = nums.length;

            // dp[i] - min number of jumps to reach the i-th index starting from 0
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j <= Math.min(i + nums[i], n - 1); j++) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
            return dp[n - 1];
        }
    }

    class JumpGame2Rev2 implements JumpGame2 {

        // O(N) time | O(N) space
        @Override
        public int jump(int[] nums) {
            int n = nums.length;

            // dp[i] - min number of jumps required to reach the last index starting from i
            int[] dp = new int[n];
            dp[n - 1] = 0;

            for (int i = n - 2; i >= 0; i--) {
                int minJumps = Integer.MAX_VALUE;
                // consider all indices reachable from i and choose the one,
                // which requires the minimum number of jumps to get to the last index
                int furthestIdx = Math.min(i + nums[i], n - 1);
                for (int k = i + 1; k <= furthestIdx; k++) {
                    minJumps = Math.min(minJumps, dp[k]);
                }
                dp[i] = (minJumps == Integer.MAX_VALUE) ? Integer.MAX_VALUE : minJumps + 1;
            }
            return dp[0];
        }
    }
}
