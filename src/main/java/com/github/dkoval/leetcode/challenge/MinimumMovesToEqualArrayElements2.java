package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

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

        // O(N^2) time | O(1) space
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

    class MinimumMovesToEqualArrayElements2BruteByFindingMedian implements MinimumMovesToEqualArrayElements2 {

        // O(NlogN) time | O(1) space
        @Override
        public int minMoves2(int[] nums) {
            // Idea: find the central point in nums[] from which each other point is nearer, i.e. median
            // Step #1: sort the input array
            Arrays.sort(nums);
            // Step #2: find the middle element of sorted array
            int n = nums.length, mid = n / 2;
            int median = (n % 2 == 0) ? (nums[mid] + nums[mid - 1]) / 2 : nums[mid];
            // Step #3: calculate number of steps to make elements equal to the median
            int numSteps = 0;
            for (int num : nums) {
                numSteps += Math.abs(num - median);
            }
            return numSteps;
        }
    }
}
