package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/twisted-mirror-path-count/">Twisted Mirror Path Count</a>
 * <p>
 * Given an m x n binary grid where:
 * <p>
 * grid[i][j] == 0 represents an empty cell, and
 * <p>
 * grid[i][j] == 1 represents a mirror.
 * <p>
 * A robot starts at the top-left corner of the grid (0, 0) and wants to reach the bottom-right corner (m - 1, n - 1).
 * It can move only right or down. If the robot attempts to move into a mirror cell, it is reflected before entering that cell:
 * <p>
 * If it tries to move right into a mirror, it is turned down and moved into the cell directly below the mirror.
 * <p>
 * If it tries to move down into a mirror, it is turned right and moved into the cell directly to the right of the mirror.
 * <p>
 * If this reflection would cause the robot to move outside the grid boundaries, the path is considered invalid and should not be counted.
 * <p>
 * Return the number of unique valid paths from (0, 0) to (m - 1, n - 1).
 * <p>
 * Since the answer may be very large, return it modulo 109 + 7.
 * <p>
 * Note: If a reflection moves the robot into a mirror cell, the robot is immediately reflected again based on the direction it used to enter that mirror:
 * if it entered while moving right, it will be turned down; if it entered while moving down, it will be turned right.
 * This process will continue until either the last cell is reached, the robot moves out of bounds or the robot moves to a non-mirror cell.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>2 <= m, n <= 500</li>
 *  <li>grid[i][j] is either 0 or 1.</li>
 *  <li>grid[0][0] == grid[m - 1][n - 1] == 0</li>
 * </ul>
 */
public interface TwistedMirrorPathCount {

    int MOD = 1_000_000_007;

    int uniquePaths(int[][] grid);

    class TwistedMirrorPathCountRev1 implements TwistedMirrorPathCount {

        private static final int[][] DIRS = {{0, 1}, {1, 0}};

        @Override
        public int uniquePaths(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            // DP top-down
            final var dp = new int[m][n][2];
            for (var rows : dp) {
                for (var cols : rows) {
                    Arrays.fill(cols, -1);
                }
            }
            // (0, 0) is never a mirror, so the initial direction doesn't matter
            return calc(grid, 0, 0, 0, dp);
        }

        // direction = 0 -> go right
        // direction = 1 -> go down
        private int calc(int[][] grid, int row, int col, int direction, int[][][] dp) {
            final var m = grid.length;
            final var n = grid[0].length;

            // base case
            if (row == m - 1 && col == n - 1) {
                return 1;
            }

            // already solved?
            if (dp[row][col][direction] != -1) {
                return dp[row][col][direction];
            }

            var total = 0;
            if (grid[row][col] == 1) {
                // case 1: hit a mirror, change direction
                final var nextDirection = 1 - direction;
                total += move(grid, row, col, nextDirection, dp);
                total %= MOD;
            } else {
                // case 2: hit an empty cell
                for (var nextDirection = 0; nextDirection < 2; nextDirection++) {
                    total += move(grid, row, col, nextDirection, dp);
                    total %= MOD;
                }
            }

            // cache and return result
            dp[row][col][direction] = total;
            return total;
        }

        private int move(int[][] grid, int row, int col, int direction, int[][][] dp) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var d = DIRS[direction];
            final var nextRow = row + d[0];
            final var nextCol = col + d[1];
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                return calc(grid, nextRow, nextCol, direction, dp);
            }
            return 0;
        }
    }
}
