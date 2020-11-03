package com.github.dkoval.leetcode.interview.array;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 * <p>
 * Notice that you may not slant the container.
 */
public abstract class ContainerWithMostWater {

    public abstract int maxArea(int[] height);

    public static class ContainerWithMostWaterBruteForce extends ContainerWithMostWater {

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

    public static class ContainerWithMostWaterTwoPointers extends ContainerWithMostWater {

        @Override
        public int maxArea(int[] height) {
            int maxArea = 0;
            int start = 0, end = height.length - 1;
            while (start < end) {
                int area = (end - start) * Math.min(height[start], height[end]);
                maxArea = Math.max(maxArea, area);
                // move the pointer pointing to the shorter height
                if (height[start] < height[end]) {
                    start++;
                } else {
                    end--;
                }
            }
            return maxArea;
        }
    }
}
