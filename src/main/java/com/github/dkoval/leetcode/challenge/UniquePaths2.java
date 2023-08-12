package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii/">Unique Paths II</a>
 * <p>
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * <p>
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * <p>
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The testcases are generated so that the answer will be less than or equal to 2 * 10^9.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == obstacleGrid.length</li>
 *  <li>n == obstacleGrid[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>obstacleGrid[i][j] is 0 or 1.</li>
 * </ul>
 */
public interface UniquePaths2 {

    int uniquePathsWithObstacles(int[][] grid);

    // O(M * N) space | O(1) space if you're allowed to modify grid[][], or O(M * N) otherwise
    class UniquePaths2DPBottomUp implements UniquePaths2 {

        @Override
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
}
