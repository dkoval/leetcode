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
public class CherryPickup2 {

    public int cherryPickup(int[][] grid) {
        // DP top-down
        int numRows = grid.length;
        int numCols = grid[0].length;
        // the maximum number of cherries that both robots can take starting on the i-th row, and column j and k of Robot 1 and 2 respectively
        Integer[][][] memo = new Integer[numRows][numCols][numCols];
        return getCherries(grid, 0, 0, numCols - 1, memo);
    }

    // O(R * C^2) time | O(R * N^2) space
    // R - number of rows, C - number of columns in the grid
    private int getCherries(int[][] grid, int row, int col1, int col2, Integer[][][] memo) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        if (row == numRows) {
            return 0;
        }

        if (memo[row][col1][col2] != null) {
            return memo[row][col1][col2];
        }

        // the number cherries two robots collect at their positions in the current row
        int numCherries = (col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2];

        // the maximum number of cherries two robots can collect in the next row
        int best = 0;
        // simulate all possible simultaneous moves of two rows to the next row
        for (int dy1 = -1; dy1 <= 1; dy1++) {
            int nextCol1 = col1 + dy1;
            if (nextCol1 < 0 || nextCol1 >= numCols) {
                continue;
            }
            for (int dy2 = -1; dy2 <= 1; dy2++) {
                int nextCol2 = col2 + dy2;
                if (nextCol2 < 0 || nextCol2 >= numCols) {
                    continue;
                }
                best = Math.max(best, getCherries(grid, row + 1, nextCol1, nextCol2, memo));
            }
        }
        return memo[row][col1][col2] = numCherries + best;
    }
}
