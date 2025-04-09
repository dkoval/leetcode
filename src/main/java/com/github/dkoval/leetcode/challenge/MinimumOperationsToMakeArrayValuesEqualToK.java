package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/">Minimum Operations to Make Array Values Equal to K</a>
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * An integer h is called valid if all values in the array that are strictly greater than h are identical.
 * <p>
 * For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10, but 5 is not a valid integer.
 * <p>
 * You are allowed to perform the following operation on nums:
 * <ul>
 *  <li>Select an integer h that is valid for the current values in nums.</li>
 *  <li>For each index i where nums[i] > h, set nums[i] to h.</li>
 * </ul>
 * Return the minimum number of operations required to make every element in nums equal to k. If it is impossible to make all elements equal to k, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 *  <li>1 <= k <= 100</li>
 * </ul>
 */
public interface MinimumOperationsToMakeArrayValuesEqualToK {

    int minOperations(int[] nums, int k);

    class MinimumOperationsToMakeArrayValuesEqualToKRev1 implements MinimumOperationsToMakeArrayValuesEqualToK {

        @Override
        public int minOperations(int[] nums, int k) {
            final var distinct = new HashSet<>();
            var count = 0;
            for (var x : nums) {
                if (x < k) {
                    return -1;
                }
                if (distinct.add(x) && x > k) {
                    count++;
                }
            }
            return count;
        }
    }
}
