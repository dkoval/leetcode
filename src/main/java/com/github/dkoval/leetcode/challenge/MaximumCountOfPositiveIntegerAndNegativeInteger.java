package com.github.dkoval.leetcode.challenge;

import java.util.function.Predicate;

/**
 * <a href="https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/">Maximum Count of Positive Integer and Negative Integer</a>
 * <p>
 * Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
 * <p>
 * In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
 * Note that 0 is neither positive nor negative.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 2000</li>
 *  <li>-2000 <= nums[i] <= 2000</li>
 *  <li>nums is sorted in a non-decreasing order.</li>
 * </ul>
 * Follow up: Can you solve the problem in O(log(n)) time complexity?
 */
public interface MaximumCountOfPositiveIntegerAndNegativeInteger {

    int maximumCount(int[] nums);

    class MaximumCountOfPositiveIntegerAndNegativeIntegerRev1 implements MaximumCountOfPositiveIntegerAndNegativeInteger {

        @Override
        public int maximumCount(int[] nums) {
            final var n = nums.length;

            final var i = findLast(nums, 0, n - 1, x -> x < 0);
            final var j = findLast(nums, i + 1, n - 1, x -> x == 0);
            return Math.max(i + 1, n - j - 1);
        }

        private int findLast(int[] nums, int left, int right, Predicate<Integer> condition) {
            // binary search
            while (left < right) {
                var mid = left + (right - left + 1) / 2;
                if (condition.test(nums[mid])) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return condition.test(nums[right]) ? right : right - 1;
        }
    }
}
