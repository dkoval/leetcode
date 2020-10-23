package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3505/">132 Pattern</a>
 * <p>
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
 * such that i < j < k and nums[i] < nums[k] < nums[j].
 * <p>
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * <p>
 * Follow up: The O(N^2) is trivial, could you come up with the O(NlogN) or the O(N) solution?
 */
public abstract class Pattern132 {

    public abstract boolean find132pattern(int[] nums);

    // Time complexity: O(N^3)
    // Space complexity: O(1)
    public static class Pattern132BruteForceInCubicTime extends Pattern132 {

        @Override
        public boolean find132pattern(int[] nums) {
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j]) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    // Time complexity: O(N^2)
    // Space complexity: O(1)
    public static class Pattern132BruteForceInQuadraticTime extends Pattern132 {

        @Override
        public boolean find132pattern(int[] nums) {
            int minI = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length - 1; j++) {
                minI = Math.min(minI, nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
                    if (minI < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
