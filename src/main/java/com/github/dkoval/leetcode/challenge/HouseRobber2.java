package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3494/">House Robber II</a>
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public abstract class HouseRobber2 {

    public abstract int rob(int[] nums);

    // Time complexity: O(N)
    // Space complexity: O(N)
    public static class HouseRobber2DPArray extends HouseRobber2 {

        @Override
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            return Math.max(doRob(nums, 0, nums.length - 2), doRob(nums, 1, nums.length - 1));
        }

        private int doRob(int[] nums, int start, int end) {
            int length = end - start + 1;
            // dp[i] represents max amount of money a one can rob up to i-th house (including i-th house)
            int[] dp = new int[length];
            if (length >= 1) {
                dp[0] = nums[start];
            }
            if (length >= 2) {
                dp[1] = Math.max(nums[start], nums[start + 1]);
            }
            for (int i = 2; i < length; i++) {
                dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
            }
            return dp[length - 1];
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(1)
    public static class HouseRobber2DPSpaceOptimized extends HouseRobber2 {

        @Override
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            return Math.max(doRob(nums, 0, nums.length - 2), doRob(nums, 1, nums.length - 1));
        }

        private int doRob(int[] nums, int start, int end) {
            int first = 0;
            int second = 0;
            for (int i = start; i <= end; i++) {
                int third = Math.max(first + nums[i], second);
                first = second;
                second = third;
            }
            return second;
        }
    }
}
