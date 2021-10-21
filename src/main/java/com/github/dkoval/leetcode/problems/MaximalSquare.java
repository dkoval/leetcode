package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public interface MaximalSquare {

    int maximalSquare(char[][] matrix);

    // Resource: https://www.youtube.com/watch?v=6X7Ha2PrDmM
    // O(M * N) time | O(M * N) space
    class MaximalSquareDPTopDown implements MaximalSquare {

        private static class Answer {
            int d = 0;

            void suggest(int d) {
                this.d = Math.max(this.d, d);
            }

            int get() {
                return d * d;
            }
        }

        @Override
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // memo[i][j] is the maximum area we can get at (i, j) as the top-left corner of a square
            // solving the problem in reverse
            Answer answer = new Answer();
            maximalSquare(matrix, 0, 0, new Integer[m][n], answer);
            return answer.get();
        }

        private int maximalSquare(char[][] matrix, int row, int col, Integer[][] memo, Answer answer) {
            int m = matrix.length;
            int n = matrix[0].length;

            if (row >= m || col >= n) {
                return 0;
            }

            if (memo[row][col] != null) {
                return memo[row][col];
            }

            memo[row][col] = 0;
            int down = maximalSquare(matrix, row + 1, col, memo, answer);
            int right = maximalSquare(matrix, row, col + 1, memo, answer);
            int diagonal = maximalSquare(matrix, row + 1, col + 1, memo, answer);

            if (matrix[row][col] == '1') {
                memo[row][col] = 1 + Math.min(Math.min(down, right), diagonal);
                answer.suggest(memo[row][col]);
            }
            return memo[row][col];
        }
    }

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
