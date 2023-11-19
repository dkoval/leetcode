package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/">Reduction Operations to Make the Array Elements Equal</a>
 * <p>
 * Given an integer array nums, your goal is to make all elements in nums equal. To complete one operation, follow these steps:
 * <ul>
 *  <li>Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. If there are multiple elements with the largest value, pick the smallest i.</li>
 *  <li> Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.</li>
 *  <li>Reduce nums[i] to nextLargest.</li>
 * </ul>
 * Return the number of operations to make all elements in nums equal.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 5 * 10^4</li>
 *  <li>1 <= nums[i] <= 5 * 10^4</li>
 * </ul>
 */
public interface ReductionOperationsToMakeArrayElementsEqual {

    int reductionOperations(int[] nums);

    class ReductionOperationsToMakeArrayElementsEqualRev1 implements ReductionOperationsToMakeArrayElementsEqual {

        @Override
        public int reductionOperations(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);

            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i + 1 < n && nums[i] == nums[i + 1]) {
                    continue;
                }

                // change all the numbers after index i to nums[i];
                // there are (n - i - 1) such numbers
                count += n - i - 1;
            }
            return count;
        }
    }
}
