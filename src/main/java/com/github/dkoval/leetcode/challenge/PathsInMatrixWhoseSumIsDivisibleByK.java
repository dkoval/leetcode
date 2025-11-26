package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/">Paths in Matrix Whose Sum Is Divisible by K (Hard)</a>
 * <p>
 * You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0)
 * and you want to reach position (m - 1, n - 1) moving only down or right.
 * <p>
 * Return the number of paths where the sum of the elements on the path is divisible by k.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <ul>m == grid.length</ul>
 *  <ul>n == grid[i].length</ul>
 *  <ul>1 <= m, n <= 5 * 10^4</ul>
 *  <ul>1 <= m * n <= 5 * 10^4</ul>
 *  <ul>0 <= grid[i][j] <= 100</ul>
 *  <ul>1 <= k <= 50</ul>
 * </ul>
 */
public interface PathsInMatrixWhoseSumIsDivisibleByK {

    int MOD = 1_000_000_007;

    int numberOfPaths(int[][] grid, int k);

    class PathsInMatrixWhoseSumIsDivisibleByRev1 implements PathsInMatrixWhoseSumIsDivisibleByK {

        // down, right
        static final int[][] DIRS = {{1, 0}, {0, 1}};

        @Override
        public int numberOfPaths(int[][] grid, int k) {
            final var m = grid.length;
            final var n = grid[0].length;

            // dp[row][col][mod] - is the number of paths from (row, col) to (m - 1, n - 1), where
            // the sum of elements on the path % k = mod
            final var dp = new Integer[m][n][k];
            return traverse(grid, k, 0, 0, grid[0][0] % k, dp);
        }

        private int traverse(int[][] grid, int k, int row, int col, int mod, Integer[][][] dp) {
            final var m = grid.length;
            final var n = grid[0].length;

            // base case
            if (row == m - 1 && col == n - 1) {
                return dp[row][col][mod] = (mod == 0) ? 1 : 0;
            }

            // already solved?
            if (dp[row][col][mod] != null) {
                return dp[row][col][mod];
            }

            var total = 0;
            for (var d : DIRS) {
                final var nextRow = row + d[0];
                final var nextCol = col + d[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                    total += traverse(grid, k, nextRow, nextCol, (grid[nextRow][nextCol] + mod) % k, dp);
                    total %= MOD;
                }
            }
            return dp[row][col][mod] = total;
        }
    }
}
