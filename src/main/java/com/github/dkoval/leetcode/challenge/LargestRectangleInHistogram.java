package com.github.dkoval.leetcode.challenge;

import java.util.Stack;

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

    // O(N) time | O(N) space
    public static class LargestRectangleInHistogramUsingStack extends LargestRectangleInHistogram {

        @Override
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1); // marks the end
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    int currHeight =  heights[stack.pop()];
                    int currWidth = i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, currHeight * currWidth);
                }
                stack.push(i);
            }
            // check if we have something left in the stack
            while (stack.peek() != -1) {
                int currHeight = heights[stack.pop()];
                int currWidth = heights.length - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            return maxArea;
        }
    }
}
