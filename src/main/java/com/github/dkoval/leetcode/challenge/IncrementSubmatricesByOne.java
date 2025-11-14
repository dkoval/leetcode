package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/increment-submatrices-by-one/">Increment Submatrices by One</a>
 * <p>
 * You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.
 * <p>
 * You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
 * <p>
 * Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i).
 * That is, add 1 to mat[x][y] for all row1i <= x <= row2i and col1i <= y <= col2i.
 * <p>
 * Return the matrix mat after performing every query.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 500</li>
 *  <li>1 <= queries.length <= 10^4</li>
 *  <li>0 <= row1i <= row2i < n</li>
 *  <li>0 <= col1i <= col2i < n</li>
 * </ul>
 */
public interface IncrementSubmatricesByOne {

    int[][] rangeAddQueries(int n, int[][] queries);

    class IncrementSubmatricesByOneRev1 implements IncrementSubmatricesByOne {

        @Override
        public int[][] rangeAddQueries(int n, int[][] queries) {
            // idea: difference array technique extended to 2D arrays
            final var ans = new int[n][n];
            for (var query : queries) {
                final var row1 = query[0];
                final var col1 = query[1];
                final var row2 = query[2];
                final var col2 = query[3];

                for (var row = row1; row <= row2; row++) {
                    // difference array technique
                    ans[row][col1]++;
                    if (col2 + 1 < n) {
                        ans[row][col2 + 1]--;
                    }
                }
            }

            // restore the final matrix from the difference array
            for (var row = 0; row < n; row++) {
                for (var col = 1; col < n; col++) {
                    ans[row][col] += ans[row][col - 1];
                }
            }
            return ans;
        }
    }
}
