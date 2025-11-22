package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/">Find Minimum Operations to Make All Elements Divisible by Three</a>
 * <p>
 * You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
 * <p>
 * Return the minimum number of operations to make all elements of nums divisible by 3.
 * <p>
 * Constraints:
 * <ul>
 *  <ul>1 <= nums.length <= 50</ul>
 *  <ul>1 <= nums[i] <= 50</ul>
 * </ul>
 */
public interface FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    int minimumOperations(int[] nums);

    class FindMinimumOperationsToMakeAllElementsDivisibleByThreeRev1 implements FindMinimumOperationsToMakeAllElementsDivisibleByThree {

        @Override
        public int minimumOperations(int[] nums) {
            var count = 0;
            for (var x : nums) {
                count += (x % 3) == 0 ? 0 : 1;
            }
            return count;
        }
    }
}
