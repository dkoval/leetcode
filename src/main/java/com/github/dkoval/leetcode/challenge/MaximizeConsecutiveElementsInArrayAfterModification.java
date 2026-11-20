package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/">Maximize Consecutive Elements in an Array After Modification</a>
 * <p>
 * You are given a 0-indexed array nums consisting of positive integers.
 * <p>
 * Initially, you can increase the value of any element in the array by at most 1.
 * <p>
 * After that, you need to select one or more elements from the final array such that those elements are consecutive when sorted in increasing order.
 * For example, the elements [3, 4, 5] are consecutive while [3, 4, 6] and [1, 1, 2, 3] are not.
 * <p>
 * Return the maximum number of elements that you can select.
 */
public interface MaximizeConsecutiveElementsInArrayAfterModification {

    int maxSelectedElements(int[] nums);

    class MaximizeConsecutiveElementsInArrayAfterModificationRev1 implements MaximizeConsecutiveElementsInArrayAfterModification {

        @Override
        public int maxSelectedElements(int[] nums) {
            final var n = nums.length;

            Arrays.sort(nums);
            final var max = nums[n - 1];

            // dp[x] is the maximum number of consecutive elements that we can select ending at x
            final var dp = new int[max + 2];
            var best = Integer.MIN_VALUE;
            for (var x : nums) {
                // option 1: increase the current number
                dp[x + 1] = Math.max(dp[x + 1], dp[x] + 1);
                best = Math.max(best, dp[x + 1]);

                // option 2: keep the current number as it is
                dp[x] = Math.max(dp[x], dp[x - 1] + 1);
                best = Math.max(best, dp[x]);
            }
            return best;
        }
    }
}
