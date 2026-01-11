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
 *  <li>1 <= row, cols <= 200</li>
 *  <li>matrix[i][j] is '0' or '1'</li>
 * </ul>
 */
public interface MaximalRectangle {

    int maximalRectangle(char[][] matrix);

    // O(M * N) time | O(N) space
    class MaximalRectangleRev1 implements MaximalRectangle {

        @Override
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length;
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

        // Resource: https://www.youtube.com/watch?v=ZmnqCZp9bBs
        // O(N) time | O(N) space
        private int areaOfLargestRectangleInHistogram(int[] hist) {
            int n = hist.length;
            int maxArea = 0;

            // mono stack: stores indices of hist[] such that for any pair of indices i < j, h[i] <= h[j]
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

            // at this stage, i == n
            while (!stack.isEmpty()) {
                int height = hist[stack.pop()];
                int area = stack.isEmpty() ? height * n : height * (n - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
        }
    }

    class MaximalRectangleRev2 implements MaximalRectangle {

        @Override
        public int maximalRectangle(char[][] matrix) {
            final var m = matrix.length;
            final var n = matrix[0].length;

            // pre-compute the prefix sum for each column
            final var prefix = new int[m + 1][n];
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    prefix[row + 1][col] = prefix[row][col] + (matrix[row][col] - '0');
                }
            }

            var best = 0;
            for (var topRow = 0; topRow < m; topRow++) {
                for (var bottomRow = 0; bottomRow < m; bottomRow++) {
                    final var height = bottomRow - topRow + 1;
                    var width = 0;
                    for (var col = 0; col < n; col++) {
                        if (columnWithAllOnes(prefix, col, topRow, bottomRow)) {
                            width++;
                        } else {
                            width = 0;
                        }
                        best = Math.max(best, height * width);
                    }
                }
            }
            return best;
        }

        private boolean columnWithAllOnes(int[][] prefix, int col, int topRow, int bottomRow) {
            return prefix[bottomRow + 1][col] - prefix[topRow][col] == bottomRow - topRow + 1;
        }
    }
}
