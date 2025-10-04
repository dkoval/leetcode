package com.github.dkoval.leetcode.interview.array;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == height.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>0 <= height[i] <= 10^4</li>
 * </ul>
 */
public interface ContainerWithMostWater {

    int maxArea(int[] height);

    class ContainerWithMostWaterBruteForce implements ContainerWithMostWater {

        @Override
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }
    }

    class ContainerWithMostWaterTwoPointers implements ContainerWithMostWater {

        @Override
        public int maxArea(int[] height) {
            final var n = height.length;

            var maxArea = 0;
            var left = 0;
            var right = n - 1;
            while (left < right) {
                final var h = Math.min(height[left], height[right]);
                final var w = right - left;
                maxArea = Math.max(maxArea, h * w);
                // move the pointer pointing to smaller height
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
    }
}
