package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/description/">Spiral Matrix</a>
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == matrix.length</li>
 *  <li>n == matrix[i].length</li>
 *  <li>1 <= m, n <= 10</li>
 *  <li>-100 <= matrix[i][j] <= 100</li>
 * </ul>
 */
public interface SpiralMatrix {

    List<Integer> spiralOrder(int[][] matrix);

    class SpiralMatrixRev1 implements SpiralMatrix {

        @Override
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            List<Integer> ans = new ArrayList<>(m * n);
            int startRow = 0, endRow = m - 1;
            int startCol = 0, endCol = n - 1;
            while (startRow <= endRow && startCol <= endCol) {
                // top row
                for (int j = startCol; j <= endCol; j++) {
                    ans.add(matrix[startRow][j]);
                }

                // right column
                for (int i = startRow + 1; i <= endRow; i++) {
                    ans.add(matrix[i][endCol]);
                }

                // bottom row
                for (int j = endCol - 1; j >= startCol && startRow < endRow; j--) {
                    ans.add(matrix[endRow][j]);
                }

                // left column
                for (int i = endRow - 1; i > startRow && startCol < endCol; i--) {
                    ans.add(matrix[i][startCol]);
                }

                startRow++;
                endRow--;

                startCol++;
                endCol--;
            }
            return ans;
        }
    }
}
