package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/">Number of Ways of Cutting a Pizza (Hard)</a>
 * <p>
 * Given a rectangular pizza represented as a rows x cols matrix containing the following characters:
 * 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts.
 * <p>
 * For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary
 * and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person.
 * If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
 * <p>
 * Return the number of ways of cutting the pizza such that each piece contains at least one apple.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= rows, cols <= 50</li>
 *  <li>rows == pizza.length</li>
 *  <li>cols == pizza[i].length</li>
 *  <li>1 <= k <= 10</li>
 *  <li>pizza consists of characters 'A' and '.' only.</li>
 * </ul>
 */
public interface NumberOfWaysOfCuttingPizza {

    int ways(String[] pizza, int k);

    class NumberOfWaysOfCuttingPizzaDPTopDown implements NumberOfWaysOfCuttingPizza {

        private static final int MOD = 1_000_000_007;

        @Override
        public int ways(String[] pizza, int k) {
            int m = pizza.length;
            int n = pizza[0].length();

            // Idea: DP
            // parameters: current row, current column, the number of remaining cuts
            Integer[][][] dp = new Integer[m][n][k];

            // Using prefix sum, precompute the number of apples in a submatrix
            // identified by (0, 0) top-left and (i, j) bottom-right corners.
            int[][] apples = apples(pizza);
            return solve(apples, 0, 0, k - 1, dp);
        }

        private int[][] apples(String[] pizza) {
            int m = pizza.length;
            int n = pizza[0].length();

            // 2D prefix sum
            // sum[i][j] - the number of apples between [0 : i] rows and [0 : j] columns
            int[][] sum = new int[m][n];

            // 1st pass - compute prefix sum for each individual row
            for (int i = 0; i < m; i++) {
                sum[i][0] = pizza[i].charAt(0) == 'A' ? 1 : 0;
                for (int j = 1; j < n; j++) {
                    sum[i][j] = sum[i][j - 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                }
            }

            // 2nd pass - finalize computation
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i][j] += sum[i - 1][j];
                }
            }
            return sum;
        }

        private int solve(int[][] apples, int row, int col, int cuts, Integer[][][] dp) {
            if (cuts == 0) {
                // give the whole slice to a person
                return 1;
            }

            // already solved?
            if (dp[row][col][cuts] != null) {
                return dp[row][col][cuts];
            }

            int m = apples.length;
            int n = apples[0].length;

            int ans = 0;

            // option #1: make a vertical cut
            for (int j = col + 1; j < n; j++) {
                if (hasApple(apples, row, m - 1, col, j - 1)
                        && hasApple(apples, row, m - 1, j, n - 1)) {
                    ans += solve(apples, row, j, cuts - 1, dp);
                    ans %= MOD;
                }
            }

            // option #2: make a horizontal cut
            for (int i = row + 1; i < m; i++) {
                if (hasApple(apples, row, i - 1, col, n - 1)
                        && hasApple(apples, i, m - 1, col, n - 1)) {
                    ans += solve(apples, i, col, cuts - 1, dp);
                    ans %= MOD;
                }
            }
            return dp[row][col][cuts] = ans;
        }

        private boolean hasApple(int[][] apples, int row1, int row2, int col1, int col2) {
            return countApples(apples, row1, row2, col1, col2) > 0;
        }

        // count apples between [row1 : row2] rows and [col1 : col2] columns
        private int countApples(int[][] apples, int row1, int row2, int col1, int col2) {
            int count = apples[row2][col2];
            count -= (row1 > 0) ? apples[row1 - 1][col2] : 0;
            count -= (col1 > 0) ? apples[row2][col1 - 1] : 0;
            count += (row1 > 0 && col1 > 0) ? apples[row1 - 1][col1 - 1] : 0;
            return count;
        }
    }
}
