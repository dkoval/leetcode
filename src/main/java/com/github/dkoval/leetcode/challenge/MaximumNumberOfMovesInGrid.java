package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/">Maximum Number of Moves in a Grid</a>
 * <p>
 * You are given a 0-indexed m x n matrix grid consisting of positive integers.
 * <p>
 * You can start at any cell in the first column of the matrix, and traverse the grid in the following way:
 * <p>
 * From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1)
 * such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
 * <p>
 * Return the maximum number of moves that you can perform.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>2 <= m, n <= 1000</li>
 *  <li>4 <= m * n <= 10^5</li>
 *  <li>1 <= grid[i][j] <= 10^6</li>
 * </ul>
 */
public interface MaximumNumberOfMovesInGrid {

    int maxMoves(int[][] grid);

    class MaximumNumberOfMovesInGridRev1 implements MaximumNumberOfMovesInGrid {

        private static final int[][] DIRS = {{-1, 1}, {0, 1}, {1, 1}};

        @Override
        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // DP top-down
            Integer[][] dp = new Integer[m][n];

            int best = 0;
            for (int row = 0; row < m; row++) {
                best = Math.max(best, traverse(grid, row, 0, dp));
            }
            return Math.max(best - 1, 0);
        }

        // Returns the maximum number of moves that can be performed when starting at (row, col)
        private int traverse(int[][] grid, int row, int col, Integer[][] dp) {
            // already solved?
            if (dp[row][col] != null) {
                return dp[row][col];
            }

            int m = grid.length;
            int n = grid[0].length;

            int moves = 0;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow < 0 || nextRow == m || nextCol == n || grid[nextRow][nextCol] <= grid[row][col]) {
                    continue;
                }
                moves = Math.max(moves, traverse(grid, nextRow, nextCol, dp));
            }
            return dp[row][col] = 1 + moves;
        }
    }

    class MaximumNumberOfMovesInGridRev2 implements MaximumNumberOfMovesInGrid {

        @Override
        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // DP bottom-up
            // dp[row][col] = (row, col) can be reached
            boolean[][] dp = new boolean[m][n];

            // base case: cells in the 0-th column are always reachable
            for (int row = 0; row < m; row++) {
                dp[row][0] = true;
            }

            int best = 0;
            for (int col = 1; col < n; col++) {
                for (int row = 0; row < m; row++) {
                    // check if (row, col) is reachable from 3 previous cells:
                    // (row - 1, col - 1), (row, col - 1), (row + 1, col - 1)
                    for (int dr = -1; dr <= 1; dr++) {
                        int prevRow = row + dr;
                        if (prevRow < 0 || prevRow == m) {
                            continue;
                        }

                        if (dp[prevRow][col - 1] && grid[prevRow][col - 1] < grid[row][col]) {
                            dp[row][col] = true;
                            break;
                        }
                    }

                    if (dp[row][col]) {
                        best = Math.max(best, col);
                    }
                }
            }
            return best;
        }
    }
}
