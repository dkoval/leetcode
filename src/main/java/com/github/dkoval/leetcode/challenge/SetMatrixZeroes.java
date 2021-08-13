package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3888/">Set Matrix Zeroes</a>
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 * <p>
 * You must do it in place.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == matrix.length</li>
 *  <li>n == matrix[0].length</li>
 *  <li>1 <= m, n <= 200</li>
 *  <li>-2^31 <= matrix[i][j] <= 2^31 - 1</li>
 * </ul>
 */
public class SetMatrixZeroes {

    // O(M*N) time | O(1) space
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // use the 1st cell of every row and column as a flag to determine
        // whether a row or column has been set to 0
        boolean setFirstRow = false;
        boolean setFirstCol = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // mark the 1st cell of the current row
                    matrix[i][0] = 0;
                    // corner case - will need to set row = 0 to 0's
                    if (i == 0) {
                        setFirstRow = true;
                    }
                    // mark the 1st cell of the current column
                    matrix[0][j] = 0;
                    // corner case - will need to set col = 0 to 0's
                    if (j == 0) {
                        setFirstCol = true;
                    }
                }
            }
        }

        // process marked rows, starting from row = 1
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                // set all cells in this row to 0
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // process marked columns, starting from col = 1
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                // set all cells in this column to 0
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // process row = 0, if needed
        if (setFirstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // process col = 0, if needed
        if (setFirstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
