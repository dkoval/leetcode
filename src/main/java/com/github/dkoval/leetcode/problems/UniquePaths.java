package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 * <p>
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 100
 */
public interface UniquePaths {

    int uniquePaths(int m, int n);

    class UniquePathsDPTopDown implements UniquePaths {

        @Override
        public int uniquePaths(int m, int n) {
            return uniquePaths(m, n, 0, 0, new Integer[m][n]);
        }

        private int uniquePaths(int m, int n, int row, int col, Integer[][] memo) {
            if (row == m - 1 && col == n - 1) {
                return 1;
            }

            // out of bounds
            if (row == m || col == n) {
                return 0;
            }

            // already solved?
            if (memo[row][col] != null) {
                return memo[row][col];
            }

            // cache and return the answer
            return memo[row][col] = uniquePaths(m, n, row + 1, col, memo) + uniquePaths(m, n, row, col + 1, memo);
        }
    }
}
