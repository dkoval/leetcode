package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public interface MaximalSquare {

    int maximalSquare(char[][] matrix);

    // Resource: https://www.youtube.com/watch?v=oPrpoVdRLtg
    // O(M * N) time | O(M * N) space
    class MaximalSquareDPBottomUp implements MaximalSquare {

        @Override
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // dp[i][j] is the dimension d of the biggest square of 1's ending at (i, j)
            int[][] dp = new int[m][n];
            int maxD = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        continue;
                    }

                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        dp[i][j] += Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }

                    maxD = Math.max(maxD, dp[i][j]);
                }
            }
            return maxD * maxD;
        }
    }
}
