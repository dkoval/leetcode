package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3748/">Minimum Moves to Equal Array Elements II</a>
 * <p>
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment or decrement an element of the array by 1.
 */
public interface MinimumMovesToEqualArrayElements2 {

    int minMoves2(int[] nums);

    class MinimumMovesToEqualArrayElements2BruteForce implements MinimumMovesToEqualArrayElements2 {

        @Override
        public int minMoves2(int[] nums) {
            long minNumMoves = Long.MAX_VALUE;
            for (int num : nums) {
                long currNumMoves = numMovesToMakeAllEqual(nums, num);
                minNumMoves = Math.min(minNumMoves, currNumMoves);
            }
            return (int) minNumMoves;
        }

        private long numMovesToMakeAllEqual(int[] nums, int x) {
            long numMoves = 0;
            for (int num : nums) {
                long diff = Math.abs((long) num - x);
                numMoves += diff;
            }
            return numMoves;
        }
    }
}
