package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/left-and-right-sum-differences/">Left and Right Sum Differences</a>
 * <p>
 * You are given a 0-indexed integer array nums of size n.
 * <p>
 * Define two arrays leftSum and rightSum where:
 * <p>
 * leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
 * <p>
 * rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
 * <p>
 * Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.
 */
public interface LeftAndRightSumDifferences {

    int[] leftRightDifference(int[] nums);

    class LeftAndRightSumDifferencesRev1 implements LeftAndRightSumDifferences {

        @Override
        public int[] leftRightDifference(int[] nums) {
            final var n = nums.length;

            final var leftSum = new int[n];
            for (var i = 1; i < n; i++) {
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
            }

            final var rightSum = new int[n];
            for (var i = n - 2; i >= 0; i--) {
                rightSum[i] = rightSum[i + 1] + nums[i + 1];
            }

            final var res = new int[n];
            for (var i = 0; i < n; i++) {
                res[i] = Math.abs(leftSum[i] - rightSum[i]);
            }
            return res;
        }
    }
}
