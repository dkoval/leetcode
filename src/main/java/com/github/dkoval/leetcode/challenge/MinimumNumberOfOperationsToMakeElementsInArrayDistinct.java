package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/">Minimum Number of Operations to Make Elements in Array Distinct</a>
 * <p>
 * You are given an integer array nums. You need to ensure that the elements in the array are distinct.
 * To achieve this, you can perform the following operation any number of times:
 * <p>
 * Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
 * <p>
 * Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed
 * to make the elements in the array distinct.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    int minimumOperations(int[] nums);

    class MinimumNumberOfOperationsToMakeElementsInArrayDistinctRev1 implements MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

        @Override
        public int minimumOperations(int[] nums) {
            final var n = nums.length;

            final var indices = new HashMap<Integer, Integer>();
            var count = 0;
            var start = 0;
            for (var i = 0; i < n && start < n; i++) {
                if (indices.containsKey(nums[i])) {
                    final var seenAt = indices.get(nums[i]);
                    while (start < n && start <= seenAt) {
                        start += 3;
                        count++;
                    }
                }
                indices.put(nums[i], i);
            }
            return count;
        }
    }
}
