package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/toeplitz-matrix/">Toeplitz Matrix</a>
 * <p>
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 * <p>
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == matrix.length</li>
 *  <li>n == matrix[i].length</li>
 *  <li>1 <= m, n <= 20</li>
 *  <li>0 <= matrix[i][j] <= 99</li>
 * </ul>
 */
public interface ToeplitzMatrix {

    boolean isToeplitzMatrix(int[][] matrix);

    class ToeplitzMatrixRev1 implements ToeplitzMatrix {

        @Override
        public boolean isToeplitzMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // label diagonals: elements at the same diagonal have the same label = i - j
            Map<Integer, Integer> diags = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int label = i - j;
                    if (diags.containsKey(label)) {
                        if (diags.get(label) != matrix[i][j]) {
                            return false;
                        }
                    } else {
                        diags.put(label, matrix[i][j]);
                    }
                }
            }
            return true;
        }
    }
}
