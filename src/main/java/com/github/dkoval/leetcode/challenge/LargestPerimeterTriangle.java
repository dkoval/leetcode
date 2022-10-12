package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-perimeter-triangle/">Largest Perimeter Triangle</a>
 * <p>
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
 * If it is impossible to form any triangle of a non-zero area, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= nums.length <= 10^4</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 * </ul>
 */
public interface LargestPerimeterTriangle {

    int largestPerimeter(int[] nums);

    // O(N * logN) time | O(1) space
    class LargestPerimeterTriangleRev1 implements LargestPerimeterTriangle {

        @Override
        public int largestPerimeter(int[] nums) {
            int n = nums.length;

            // Triangle inequality:
            // a + b > c, where a < b < c
            Arrays.sort(nums);

            // the goal is to get the largest perimeter possible,
            // therefore iterate over nums[] in reverse order
            for (int i = n - 1; i >= 2; i--) {
                int c = nums[i];
                int b = nums[i - 1];
                int a = nums[i - 2];

                if (a + b > c) {
                    return a + b + c;
                }
            }
            return 0;
        }
    }
}
