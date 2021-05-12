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
        private final int[][] sum;

        public NumMatrix(int[][] matrix) {
            this.sum = calcRowRunningSum(matrix);
        }

        private static int[][] calcRowRunningSum(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] sum = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i][j] = matrix[i][j] + (j > 0 ? sum[i][j - 1] : 0);
                }
            }
            return sum;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int result = 0;
            for (int i = row1; i <= row2; i++) {
                result += sum[i][col2] - (col1 > 0 ? sum[i][col1 - 1] : 0);
            }
            return result;
        }
    }
}
