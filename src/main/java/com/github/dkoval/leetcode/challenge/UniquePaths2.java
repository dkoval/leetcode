package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3723/">Unique Paths II</a>
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 */
public class UniquePaths2 {

    // O(M * N) space | O(1) space if you're allowed to modify grid[][], or O(M * N) otherwise
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // no solution
        if (isObstacle(grid, 0, 0) || isObstacle(grid, m - 1, n - 1)) {
            return 0;
        }

        // turn grid into a DP table, where grid[i][j] is the number of unique paths from (0, 0) to (i, j)
        grid[0][0] = 1;

        // fill cells in the 1st row
        for (int j = 1; j < n; j++) {
            // if a cell in the 1st row is not an obstacle, it can only be reached from the cell left to it
            grid[0][j] = isObstacle(grid, 0, j) ? 0 : grid[0][j - 1];
        }

        // fill cells in the 1st column
        for (int i = 1; i < m; i++) {
            // if a cell in the 1st column is not an obstacle, it can only be reached from the cell above it
            grid[i][0] = isObstacle(grid, i, 0) ? 0 : grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // if current cell is not an obstacle, it can be reached from the cell left to it or from the cell above it
                grid[i][j] = isObstacle(grid, i, j) ? 0 : grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    private boolean isObstacle(int[][] grid, int row, int col) {
        return grid[row][col] == 1;
    }
}
