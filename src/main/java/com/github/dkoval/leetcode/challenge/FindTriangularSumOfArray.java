package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-triangular-sum-of-an-array/">Find Triangular Sum of an Array</a>
 * <p>
 * You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).
 * <p>
 * The triangular sum of nums is the value of the only element present in nums after the following process terminates:
 * <ul>
 *  <li>Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.</li>
 *  <li>For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.</li>
 *  <li>Replace the array nums with newNums.</li>
 *  <li>Repeat the entire process starting from step 1.</li>
 * </ul>
 * Return the triangular sum of nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>0 <= nums[i] <= 9</li>
 * </ul>
 */
public interface FindTriangularSumOfArray {

    int triangularSum(int[] nums);

    class FindTriangularSumOfArrayRev1 implements FindTriangularSumOfArray {

        @Override
        public int triangularSum(int[] nums) {
            final var n = nums.length;

            // run simulation
            for (var i = 0; i < n - 1; i++) {
                var prev = nums[0];
                for (var j = 0; j < n - i - 1; j++) {
                    nums[j] = prev + nums[j + 1];
                    nums[j] %= 10;
                    prev = nums[j + 1];
                }
            }
            return nums[0];
        }
    }
}
