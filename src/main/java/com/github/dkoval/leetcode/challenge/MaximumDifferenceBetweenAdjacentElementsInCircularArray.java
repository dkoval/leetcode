package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/">Maximum Difference Between Adjacent Elements in a Circular Array</a>
 * <p>
 * Given a circular array nums, find the maximum absolute difference between adjacent elements.
 * <p>
 * Note: In a circular array, the first and last elements are adjacent.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 100</li>
 *  <li>-100 <= nums[i] <= 100</li>
 * </ul>
 */
public interface MaximumDifferenceBetweenAdjacentElementsInCircularArray {

    int maxAdjacentDistance(int[] nums);

    class MaximumDifferenceBetweenAdjacentElementsInCircularArrayRev1 implements MaximumDifferenceBetweenAdjacentElementsInCircularArray {

        public int maxAdjacentDistance(int[] nums) {
            final var n = nums.length;

            var best = 0;
            for (var i = 0; i < n; i++) {
                final var diff = Math.abs(nums[i] - nums[(i + 1) % n]);
                best = Math.max(best, diff);
            }
            return best;
        }
    }
}
