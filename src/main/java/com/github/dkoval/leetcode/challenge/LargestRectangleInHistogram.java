package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3587/">Largest Rectangle in Histogram</a>
 * <p>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public interface LargestRectangleInHistogram {

    int largestRectangleArea(int[] heights);

    // O(N^2) time | O(1) space
    class LargestRectangleInHistogramBruteForce implements LargestRectangleInHistogram {

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
    class LargestRectangleInHistogramUsingStack implements LargestRectangleInHistogram {

        private static class Rectangle {
            final int startAt;
            final int height;

            Rectangle(int startAt, int height) {
                this.startAt = startAt;
                this.height = height;
            }
        }

        // Resource: https://www.youtube.com/watch?v=zx5Sw9130L0
        @Override
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int maxArea = 0;

            Deque<Rectangle> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                // fix the starting index of the current rectangle
                int startAt = i;
                // check if we can further extend the previous rectangle to the right
                while (!stack.isEmpty() &&  stack.peek().height > heights[i]) {
                    // we can't longer extend the previous rectangle to the right,
                    // therefore compute the covered area and pop it from the stack
                    Rectangle top = stack.pop();
                    maxArea = Math.max(maxArea, (i - top.startAt) * top.height);
                    // the previous rectangle of larger height has gone now, therefore we can now extend the current rectangle to the left
                    startAt = top.startAt;
                }
                stack.push(new Rectangle(startAt, heights[i]));
            }

            // is stack still not empty?
            while (!stack.isEmpty()) {
                Rectangle top = stack.pop();
                maxArea = Math.max(maxArea, (n - top.startAt) * top.height);
            }
            return maxArea;
        }
    }
}
