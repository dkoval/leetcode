package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/out-of-boundary-paths/">Out of Boundary Paths</a>
 * <p>
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary).
 * You can apply at most maxMove moves to the ball.
 * <p>
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary.
 * Since the answer can be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m, n <= 50</li>
 *  <li>0 <= maxMove <= 50</li>
 *  <li>0 <= startRow < m</li>
 *  <li>0 <= startColumn < n</li>
 * </ul>
 */
public interface OutOfBoundaryPaths {

    int MOD = 1_000_000_007;

    int findPaths(int m, int n, int maxMove, int startRow, int startColumn);

    class OutOfBoundaryPathsDPBottomUpRev1 implements OutOfBoundaryPaths {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            // dp[i][j] is the number of ways to get to (i, j)
            int[][] dp = new int[m][n];
            dp[startRow][startColumn] = 1;

            // simulation + DP bottom-up
            int count = 0;
            while (maxMove-- > 0) {
                int[][] nextDp = new int[m][n];
                for (int row = 0; row < m; row++) {
                    for (int col = 0; col < n; col++) {
                        if (dp[row][col] == 0) {
                            continue;
                        }

                        for (int[] d : DIRS) {
                            int nextRow = row + d[0];
                            int nextCol = col + d[1];
                            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                                nextDp[nextRow][nextCol] += dp[row][col];
                                nextDp[nextRow][nextCol] %= MOD;
                            } else {
                                // out of the grid boundary
                                count += dp[row][col];
                                count %= MOD;
                            }
                        }
                    }
                }
                dp = nextDp;
            }
            return count;
        }
    }
}
