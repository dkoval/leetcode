package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/">Minimum Operations to Make Array Sum Divisible by K</a>
 * <p>
 * You are given an integer array nums and an integer k. You can perform the following operation any number of times:
 * <p>
 * Select an index i and replace nums[i] with nums[i] - 1.
 * <p>
 * Return the minimum number of operations required to make the sum of the array divisible by k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 1000</li>
 *  <li>1 <= k <= 100</li>
 * </ul>
 */
public interface MinimumOperationsToMakeArraySumDivisibleByK {

    int minOperations(int[] nums, int k);

    class MinimumOperationsToMakeArraySumDivisibleByKRev1 implements MinimumOperationsToMakeArraySumDivisibleByK {

        @Override
        public int minOperations(int[] nums, int k) {
            var sum = 0;
            for (var x : nums) {
                sum += x;
            }
            return sum % k;
        }
    }
}
