package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-increasing-elements/">Maximum Difference Between Increasing Elements</a>
 * <p>
 * Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]),
 * such that 0 <= i < j < n and nums[i] < nums[j].
 * <p>
 * Return the maximum difference. If no such i and j exists, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>2 <= n <= 1000</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface MaximumDifferenceBetweenIncreasingElements {

    int maximumDifference(int[] nums);

    class MaximumDifferenceBetweenIncreasingElementsRev1 implements MaximumDifferenceBetweenIncreasingElements {

        @Override
        public int maximumDifference(int[] nums) {
            final var n = nums.length;

            var best = -1;
            for (var i = 0; i < n - 1; i++) {
                for (var j = i + 1; j < n; j++) {
                    if (nums[i] < nums[j]) {
                        best = Math.max(best, nums[j] - nums[i]);
                    }
                }
            }
            return best;
        }
    }

    class MaximumDifferenceBetweenIncreasingElementsRev2 implements MaximumDifferenceBetweenIncreasingElements {

        @Override
        public int maximumDifference(int[] nums) {
            final var n = nums.length;

            var best = -1;
            var min = nums[0];
            for (var i = 1; i < n; i++) {
                if (nums[i] > min) {
                    best = Math.max(best, nums[i] - min);
                } else {
                    min = nums[i];
                }
            }
            return best;
        }
    }
}
