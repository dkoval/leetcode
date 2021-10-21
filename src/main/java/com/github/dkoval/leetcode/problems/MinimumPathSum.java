package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/">Minimum Path Sum</a>
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * </ul>
 */
public class MinimumPathSum {

    // O(M * N) time | O(M *N) space
    public int minPathSum(int[][] grid) {
        // DP: bottom-up
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j] is the minimum possible sum of a path from (0, 0) to (i, j)
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // 1st row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 1st column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
