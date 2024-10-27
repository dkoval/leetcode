package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-square-submatrices-with-all-ones/">Count Square Submatrices with All Ones</a>
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 300</li>
 *  <li>1 <= arr[0].length <= 300</li>
 *  <li>0 <= arr[i][j] <= 1</li>
 * </ul>
 */
public interface CountSquareSubmatricesWithAllOnes {

    int countSquares(int[][] matrix);

    class CountSquareSubmatricesWithAllOnesRev2 implements CountSquareSubmatricesWithAllOnes {

        @Override
        public int countSquares(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // dp[i][j] - how many squares can be formed having (i, j) as their bottom-right corner.
            // The answer to the problem is the sum of dp[i][j].
            int[][] dp = new int[m][n];

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }

                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        dp[i][j] += Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                    count += dp[i][j];
                }
            }
            return count;
        }
    }
}
