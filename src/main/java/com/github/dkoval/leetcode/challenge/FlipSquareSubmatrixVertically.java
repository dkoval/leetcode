package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/flip-square-submatrix-vertically/">Flip Square Submatrix Vertically</a>
 * <p>
 * You are given an m x n integer matrix grid, and three integers x, y, and k.
 * <p>
 * The integers x and y represent the row and column indices of the top-left corner of a square submatrix and the integer k
 * represents the size (side length) of the square submatrix.
 * <p>
 * Your task is to flip the submatrix by reversing the order of its rows vertically.
 * <p>
 * Return the updated matrix.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 50</li>
 *  <li>1 <= grid[i][j] <= 100</li>
 *  <li>0 <= x < m</li>
 *  <li>0 <= y < n</li>
 *  <li>1 <= k <= min(m - x, n - y)</li>
 * </ul>
 */
public interface FlipSquareSubmatrixVertically {

    int[][] reverseSubmatrix(int[][] grid, int x, int y, int k);

    class FlipSquareSubmatrixVerticallyRev1 implements FlipSquareSubmatrixVertically {

        @Override
        public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
            for (var col = y; col < y + k; col++) {
                var topRow = x;
                var bottomRow = x + k - 1;
                while (topRow < bottomRow) {
                    swap(grid, topRow++, bottomRow--, col);
                }
            }
            return grid;
        }

        private void swap(int[][] grid, int topRow, int bottomRow, int col) {
            var tmp = grid[topRow][col];
            grid[topRow][col] = grid[bottomRow][col];
            grid[bottomRow][col] = tmp;
        }
    }
}
