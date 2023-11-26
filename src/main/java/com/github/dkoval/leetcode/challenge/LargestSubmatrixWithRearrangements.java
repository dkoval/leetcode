package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-submatrix-with-rearrangements/">Largest Submatrix With Rearrangements</a>
 * <p>
 * You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.
 * <p>
 * Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == matrix.length</li>
 *  <li>n == matrix[i].length</li>
 *  <li>1 <= m * n <= 10^5</li>
 *  <li>matrix[i][j] is either 0 or 1.</li>
 * </ul>
 */
public interface LargestSubmatrixWithRearrangements {

    int largestSubmatrix(int[][] matrix);

    class LargestSubmatrixWithRearrangementsRev1 implements LargestSubmatrixWithRearrangements {

        @Override
        public int largestSubmatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // for each column, find the number of consecutive 1's ending at each position
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < m; row++) {
                    if (matrix[row][col] == 0) {
                        continue;
                    }

                    if (row > 0 && matrix[row - 1][col] > 0) {
                        matrix[row][col] = matrix[row - 1][col] + 1;
                    }
                }
            }

            int best = 0;
            // for each row, sort consecutive 1's
            for (int[] row : matrix) {
                Arrays.sort(row);
                // process each row in DESC order
                for (int i = n - 1; i >= 0 && row[i] > 0; i--) {
                    // row[i] denotes the bottom-right cornet of a rectangle
                    int height = row[i];
                    int width = n - i;
                    best = Math.max(best, height * width);
                }
            }
            return best;
        }
    }
}
