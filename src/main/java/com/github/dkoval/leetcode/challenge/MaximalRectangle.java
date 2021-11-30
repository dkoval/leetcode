package com.github.dkoval.leetcode.challenge;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/maximal-rectangle/">Maximal Rectangle (Hard)</a>
 * <p>
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Constraints:
 * <ul>
 *  <li>rows == matrix.length</li>
 *  <li>cols == matrix[i].length</li>
 *  <li>0 <= row, cols <= 200</li>
 *  <li>matrix[i][j] is '0' or '1'</li>
 * </ul>
 */
public class MaximalRectangle {

    // O(M * N) time | O(N) space
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int maxArea = 0;

        // Given row i and column j, hist[j] is the height of histogram at index j at level.
        // For example:
        // 1   1     <- row 0, level 0
        // 1   1 1 1 <- row 1, level 1
        // 1 1 1 1 1 <- row 2, level 2
        int[] hist = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hist[j] = matrix[i][j] == '1' ? hist[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, areaOfLargestRectangleInHistogram(hist));
        }
        return maxArea;
    }

    // O(N) time | O(N) space
    private int areaOfLargestRectangleInHistogram(int[] hist) {
        int n = hist.length;
        int maxArea = 0;

        // stores indices of hist[]
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && hist[i] < hist[stack.peek()]) {
                int height = hist[stack.pop()];
                int area = stack.isEmpty() ? height * i : height * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = hist[stack.pop()];
            int area = stack.isEmpty() ? height * n : height * (n - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
