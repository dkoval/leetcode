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

        @Override
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int maxArea = 0;

            // stores indices such that for any indices k < l < m, heights[k] < heights[l] < heights[m]
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1); // marks the end

            for (int i = 0; i < n; i++) {
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
                int currWidth = n - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            return maxArea;
        }
    }
}
