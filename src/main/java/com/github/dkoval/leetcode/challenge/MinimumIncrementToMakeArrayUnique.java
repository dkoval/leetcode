package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-increment-to-make-array-unique/">Minimum Increment to Make Array Unique</a>
 * <p>
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 * <p>
 * Return the minimum number of moves to make every value in nums unique.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface MinimumIncrementToMakeArrayUnique {

    int minIncrementForUnique(int[] nums);

    // O(N * logN) time | O(1) extra space
    class MinimumIncrementToMakeArrayUniqueRev1 implements MinimumIncrementToMakeArrayUnique {

        @Override
        public int minIncrementForUnique(int[] nums) {
            int n = nums.length;

            Arrays.sort(nums);

            int moves = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i - 1] > 0) {
                    continue;
                }
                // greedy: to reduce the number of moves and satisfy the uniqueness requirement,
                // set the current number to (prev + 1)
                int target = nums[i - 1] + 1;
                moves += target - nums[i];
                nums[i] = target;
            }
            return moves;
        }
    }
}
