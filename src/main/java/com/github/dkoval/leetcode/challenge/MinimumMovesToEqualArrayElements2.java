package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/">Minimum Moves to Equal Array Elements II</a>
 * <p>
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment or decrement an element of the array by 1.
 * <p>
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
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

    class MinimumMovesToEqualArrayElements2ByFindingMedian implements MinimumMovesToEqualArrayElements2 {

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

    // Resource: https://www.youtube.com/watch?v=FGgL5QxZLno
    class MinimumMovesToEqualArrayElements2UsingTwoPointers implements MinimumMovesToEqualArrayElements2 {

        // O(NlogN) time | O(1) space
        @Override
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int numsSteps = 0;
            int l = 0, r = nums.length - 1;
            while (l < r) {
                numsSteps += nums[r--] - nums[l++];
            }
            return numsSteps;
        }
    }
}
