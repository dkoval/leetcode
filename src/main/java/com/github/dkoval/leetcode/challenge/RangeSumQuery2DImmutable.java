package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3740/">Range Sum Query 2D - Immutable</a>
 * <p>
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and
 * lower right corner (row2, col2).
 * <p>
 * Implement the NumMatrix class:
 * <ul>
 *  <li>NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.</li>
 *  <li>
 *  int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside
 *  the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *  </li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == matrix.length</li>
 *  <li>n == matrix[i].length</li>
 *  <li>1 <= m, n <= 200</li>
 *  <li>-10^5 <= matrix[i][j] <= 10^5</li>
 *  <li>0 <= row1 <= row2 < m</li>
 *  <li>0 <= col1 <= col2 < n</li>
 *  <li>At most 10^4 calls will be made to sumRegion</li>
 * </ul>
 */
public class RangeSumQuery2DImmutable {

    public static class NumMatrix {
        // sum[i][j] denotes sum of the elements of matrix defined by
        // its upper left corner (0, 0) and lower right corner (i, j)
        private final int[][] sum;

        public NumMatrix(int[][] matrix) {
            this.sum = calcSums(matrix);
        }

        private static int[][] calcSums(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] sum = new int[m][n];

            // compute prefix sum for each row
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i][j] = matrix[i][j] + (j > 0 ? sum[i][j - 1] : 0);
                }
            }

            // compute prefix sum for each column
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i][j] += sum[i - 1][j];
                }
            }
            return sum;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getSum(sum, row2, col2)
                    - getSum(sum, row2, col1 - 1)
                    - getSum(sum, row1 - 1, col2)
                    + getSum(sum, row1 - 1, col1 - 1);
        }

        private int getSum(int[][] sum, int row, int col) {
            if (row < 0 || row >= sum.length || col < 0 || col >= sum[0].length) {
                return 0;
            }
            return sum[row][col];
        }
    }
}
