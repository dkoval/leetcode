package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-distance-to-the-target-element/">Minimum Distance to the Target Element</a>
 * <p>
 * Given an integer array nums (0-indexed) and two integers target and start, find an index i such that nums[i] == target
 * and abs(i - start) is minimized. Note that abs(x) is the absolute value of x.
 * <p>
 * Return abs(i - start).
 * <p>
 * It is guaranteed that target exists in nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 104</li>
 *  <li>0 <= start < nums.length</li>
 *  <li>target is in nums.</li>
 * </ul>
 */
public interface MinimumDistanceToTargetElement {

    int getMinDistance(int[] nums, int target, int start);

    class MinimumDistanceToTargetElementRev1 implements MinimumDistanceToTargetElement {

        @Override
        public int getMinDistance(int[] nums, int target, int start) {
            final var n = nums.length;

            var best = Integer.MAX_VALUE;
            for (var i = 0; i < n; i++) {
                if (nums[i] == target) {
                    best = Math.min(best, Math.abs(i - start));
                }
            }
            return best;
        }
    }
}
