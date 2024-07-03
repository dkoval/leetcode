package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/">Minimum Difference Between Largest and Smallest Value in Three Moves</a>
 * <p>
 * You are given an integer array nums.
 * <p>
 * In one move, you can choose one element of nums and change it to any value.
 * <p>
 * Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    int minDifference(int[] nums);

    class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesRev1 implements MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

        @Override
        public int minDifference(int[] nums) {
            int n = nums.length;

            if (n <= 4) {
                // all numbers can be replaced with the smallest one in <= 3 moves
                return 0;
            }

            // [min ... max]
            //  -->     <--
            // maximize   minimize
            //
            // Changing a number is equivalent to removing it and moving to the next
            // smallest (or largest) number.
            //
            // Therefore, we only care about 4 smallest and largest numbers and
            // combinations of these numbers that can be done in up to 3 moves.
            Arrays.sort(nums);

            int best = Integer.MAX_VALUE;
            for (int left = 0; left <= 3; left++) {
                for (int right = 0; right <= 3 - left; right++) {
                    best = Math.min(best, nums[n - 1 - right] - nums[left]);
                }
            }
            return best;
        }
    }
}
