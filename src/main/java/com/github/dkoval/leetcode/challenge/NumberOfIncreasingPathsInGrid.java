package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/">Number of Increasing Paths in a Grid (Hard)</a>
 * <p>
 * You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.
 * <p>
 * Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell.
 * Since the answer may be very large, return it modulo 109 + 7.
 * <p>
 * Two paths are considered different if they do not have exactly the same sequence of visited cells.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 1000</li>
 *  <li>1 <= m * n <= 10^5</li>
 *  <li>1 <= grid[i][j] <= 10^5</li>
 * </ul>
 */
public interface NumberOfIncreasingPathsInGrid {

    int countPaths(int[][] grid);

    // O(M * N) time | O(M * N) space
    class NumberOfIncreasingPathsInGridRev1 implements NumberOfIncreasingPathsInGrid {
        private static final int MOD = 1_000_000_007;

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int countPaths(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // Idea: DFS + DP + memoization
            // dp[row][col] - the number of increasing paths starting at (row, col)
            Integer[][] dp = new Integer[m][n];

            int count = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    // "strictly increasing paths" property defines a DAG (no need to worry about cycles)
                    count += count(grid, row, col, dp);
                    count %= MOD;
                }
            }
            return count;
        }

        private int count(int[][] grid, int row, int col, Integer[][] dp) {
            // already solved?
            if (dp[row][col] != null) {
                return dp[row][col];
            }

            int m = grid.length;
            int n = grid[0].length;

            int count = 1;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[row][col] < grid[nextRow][nextCol]) {
                    count += count(grid, nextRow, nextCol, dp);
                    count %= MOD;
                }
            }
            return dp[row][col] = count;
        }
    }
}
