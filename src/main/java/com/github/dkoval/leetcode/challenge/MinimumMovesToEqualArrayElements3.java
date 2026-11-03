package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/">Minimum Moves to Equal Array Elements III</a>
 * <p>
 * You are given an integer array nums.
 * <p>
 * In one move, you may increase the value of any single element nums[i] by 1.
 * <p>
 * Return the minimum total number of moves required so that all elements in nums become equal.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface MinimumMovesToEqualArrayElements3 {

    int minMoves(int[] nums);

    class MinimumMovesToEqualArrayElements3Rev1 implements MinimumMovesToEqualArrayElements3 {

        @Override
        public int minMoves(int[] nums) {
            var max = Integer.MIN_VALUE;
            for (var x : nums) {
                max = Math.max(max, x);
            }

            var total = 0;
            for (var x : nums) {
                total += max - x;
            }
            return total;
        }
    }
}
