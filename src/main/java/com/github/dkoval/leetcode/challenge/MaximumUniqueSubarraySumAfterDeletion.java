package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/d">Maximum Unique Subarray Sum After Deletion</a>
 * <p>
 * You are given an integer array nums.
 * <p>
 * You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:
 * <p>
 * All elements in the subarray are unique.
 * The sum of the elements in the subarray is maximized.
 * Return the maximum sum of such a subarray.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>-100 <= nums[i] <= 100</li>
 * </ul>
 */
public interface MaximumUniqueSubarraySumAfterDeletion {

    int maxSum(int[] nums);

    class MaximumUniqueSubarraySumAfterDeletionRev1 implements MaximumUniqueSubarraySumAfterDeletion {

        @Override
        public int maxSum(int[] nums) {
            final var n = nums.length;

            var sum = 0;
            var max = Integer.MIN_VALUE;
            var uniq = new HashSet<Integer>();
            for (var x : nums) {
                max = Math.max(max, x);

                if (x <= 0) {
                    continue;
                }

                if (!uniq.contains(x)) {
                    sum += x;
                }
                uniq.add(x);
            }

            // corner case: all nums[i] are negative
            if (max < 0) {
                return max;
            }

            return sum;
        }
    }
}
