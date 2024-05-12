package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/largest-local-values-in-a-matrix/">Largest Local Values in a Matrix</a>
 * <p>
 * You are given an n x n integer matrix grid.
 * <p>
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * <p>
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
 * <p>
 * Return the generated matrix.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length == grid[i].length</li>
 *  <li>3 <= n <= 100</li>
 *  <li>1 <= grid[i][j] <= 100</li>
 * </ul>
 */
public interface LargestLocalValuesInMatrix {

    int[][] largestLocal(int[][] grid);

    class LargestLocalValuesInMatrixRev1 implements LargestLocalValuesInMatrix {

        private static final int WINDOW_SIZE = 3;

        @Override
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;

            int[][] ans = new int[n - 2][n - 2];
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    ans[i][j] = getMaxLocal(grid, i, j);
                }
            }
            return ans;
        }

        // (row, col) denotes the top-left corner of a 3 x 3 window in the grid
        private int getMaxLocal(int[][] grid, int row, int col) {
            int best = Integer.MIN_VALUE;
            for (int i = row; i < row + WINDOW_SIZE; i++) {
                for (int j = col; j < col + WINDOW_SIZE; j++) {
                    best = Math.max(best, grid[i][j]);
                }
            }
            return best;
        }
    }
}
