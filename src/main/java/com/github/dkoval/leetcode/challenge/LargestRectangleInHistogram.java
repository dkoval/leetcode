package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3587/">Largest Rectangle in Histogram</a>
 * <p>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public abstract class LargestRectangleInHistogram {

    public abstract int largestRectangleArea(int[] heights);

    // O(N^2) time | O(1) space
    public static class LargestRectangleInHistogramBruteForce extends LargestRectangleInHistogram {

        @Override
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                int minHeight = heights[i];
                for (int j = i; j < heights.length; j++) {
                    minHeight = Math.min(minHeight, heights[j]);
                    maxArea = Math.max(maxArea, minHeight * (j - i + 1));
                }
            }
            return maxArea;
        }
    }
}
