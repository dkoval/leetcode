package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/matrix-diagonal-sum/">Matrix Diagonal Sum</a>
 * <p>
 * Given a square matrix mat, return the sum of the matrix diagonals.
 * <p>
 * Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == mat.length == mat[i].length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= mat[i][j] <= 100</li>
 * </ul>
 */
public interface MatrixDiagonalSum {

    int diagonalSum(int[][] mat);

    class MatrixDiagonalSumRev1 implements MatrixDiagonalSum {

        @Override
        public int diagonalSum(int[][] mat) {
            int n = mat.length;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                // include element on the primary diagonal
                sum += mat[i][i];
                // include element on the secondary diagonal
                sum += mat[i][n - i - 1];
            }

            // make sure the "center" element gets included only once
            if (n % 2 != 0) {
                sum -= mat[n / 2][n / 2];
            }
            return sum;
        }
    }
}
