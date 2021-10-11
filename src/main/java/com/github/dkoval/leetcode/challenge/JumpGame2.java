package com.github.dkoval.leetcode.challenge;

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
