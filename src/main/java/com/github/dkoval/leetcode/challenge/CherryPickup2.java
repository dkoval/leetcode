package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/cherry-pickup-ii/">Cherry Pickup II (Hard)</a>
 * <p>
 * You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.
 * <p>
 * You have two robots that can collect cherries for you:
 * <ul>
 *  <li>Robot #1 is located at the top-left corner (0, 0), and</li>
 *  <li>Robot #2 is located at the top-right corner (0, cols - 1).</li>
 * </ul>
 * Return the maximum number of cherries collection using both robots by following the rules below:
 * <ul>
 *  <li>From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).</li>
 *  <li>When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.</li>
 *  <li>When both robots stay in the same cell, only one takes the cherries.</li>
 *  <li>Both robots cannot move outside of the grid at any moment.</li>
 *  <li>Both robots should reach the bottom row in grid.</li>
 * </ul>
 */
public interface CherryPickup2 {

    int cherryPickup(int[][] grid);

    // O(R * C^2) time | O(R * N^2) space
    // R - number of rows, C - number of columns in the grid
    class CherryPickup2DPTopDown implements CherryPickup2 {

        public int cherryPickup(int[][] grid) {
            int numRows = grid.length;
            int numCols = grid[0].length;

            // DP top-down
            // dp[row][col1][col2] the maximum number of cherries two bots can collect when
            // both start on the `row` row, whereas bot 1 is on `col1` and bot 2 is on column `col2`
            return calc(grid, 0, 0, numCols - 1, new Integer[numRows][numCols][numCols]);
        }

        private int calc(int[][] grid, int row, int col1, int col2, Integer[][][] dp) {
            int numRows = grid.length;
            int numCols = grid[0].length;

            // base case #1: nothing to do
            if (row == numRows) {
                return 0;
            }

            // base case #2: either bot 1 or bot 2 is out of bounds
            if (Math.min(col1, col2) < 0 || Math.max(col1, col2) == numCols) {
                return Integer.MIN_VALUE;
            }

            // already solved?
            if (dp[row][col1][col2] != null) {
                return dp[row][col1][col2];
            }

            // the number cherries two robots collect at their positions in the current row
            int total = (col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2];

            // simulate all possible 9 combinations of moves that 2 bots can make
            int best = Integer.MIN_VALUE;
            for (int dc1 = -1; dc1 <= 1; dc1++) {
                for (int dc2 = -1; dc2 <= 1; dc2++) {
                    best = Math.max(best, total + calc(grid, row + 1, col1 + dc1, col2 + dc2, dp));
                }
            }
            return dp[row][col1][col2] = best;
        }
    }
}
