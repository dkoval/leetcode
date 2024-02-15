package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/">Find Polygon With the Largest Perimeter</a>
 * <p>
 * You are given an array of positive integers nums of length n.
 * <p>
 * A polygon is a closed plane figure that has at least 3 sides. The longest side of a polygon is smaller than the sum of its other sides.
 * <p>
 * Conversely, if you have k (k >= 3) positive real numbers a1, a2, a3, ..., ak
 * where a1 <= a2 <= a3 <= ... <= ak and a1 + a2 + a3 + ... + ak-1 > ak,
 * then there always exists a polygon with k sides whose lengths are a1, a2, a3, ..., ak.
 * <p>
 * The perimeter of a polygon is the sum of lengths of its sides.
 * <p>
 * Return the largest possible perimeter of a polygon whose sides can be formed from nums, or -1 if it is not possible to create a polygon.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface FindPolygonWithLargestPerimeter {

    long largestPerimeter(int[] nums);

    class FindPolygonWithLargestPerimeterRev1 implements FindPolygonWithLargestPerimeter {

        @Override
        public long largestPerimeter(int[] nums) {
            int n = nums.length;

            Arrays.sort(nums);

            long[] prefixSum = new long[n];
            prefixSum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] += prefixSum[i - 1] + nums[i];
            }

            // greedily choose the largest possible perimeter
            for (int i = n - 1; i >= 2; i--) {
                if (prefixSum[i - 1] > nums[i]) {
                    return prefixSum[i];
                }
            }
            return -1;
        }
    }
}
