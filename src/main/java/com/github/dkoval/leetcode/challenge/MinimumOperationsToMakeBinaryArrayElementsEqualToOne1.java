package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/">Minimum Operations to Make Binary Array Elements Equal to One I</a>
 * <p>
 * You are given a binary array nums.
 * <p>
 * You can do the following operation on the array any number of times (possibly zero):
 * <p>
 * Choose any 3 consecutive elements from the array and flip all of them.
 * <p>
 * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
 * <p>
 * Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 1</li>
 * </ul>
 */
public interface MinimumOperationsToMakeBinaryArrayElementsEqualToOne1 {

    int minOperations(int[] nums);

    class MinimumOperationsToMakeBinaryArrayElementsEqualToOne1Rev1 implements MinimumOperationsToMakeBinaryArrayElementsEqualToOne1 {

        @Override
        public int minOperations(int[] nums) {
            final var n = nums.length;

            var count = 0;
            for (var i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    continue;
                }

                if (i + 3 > n) {
                    return -1;
                }

                for (var j = i; j < i + 3; j++) {
                    nums[j] ^= 1;
                }
                count++;
            }
            return count;
        }

    }
}
