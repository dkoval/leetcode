package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/lucky-numbers-in-a-matrix/">Lucky Numbers in a Matrix</a>
 * <p>
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * <p>
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == mat.length</li>
 *  <li>n == mat[i].length</li>
 *  <li>1 <= n, m <= 50</li>
 *  <li>1 <= matrix[i][j] <= 10^5</li>
 *  <li>All elements in the matrix are distinct</li>
 * </ul>
 */
public interface LuckyNumberInMatrix {

    List<Integer> luckyNumbers(int[][] matrix);

    class LuckyNumberInMatrixRev1 implements LuckyNumberInMatrix {

        @Override
        public List<Integer> luckyNumbers(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // minInRow[i] - the minimum element in the i-th row
            int[] minInRow = new int[m];
            Arrays.fill(minInRow, Integer.MAX_VALUE);

            // maxInCol[j] - the maximum element in the j-th column
            int[] maxInCol = new int[n];
            Arrays.fill(maxInCol, Integer.MIN_VALUE);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    minInRow[i] = Math.min(minInRow[i], matrix[i][j]);
                    maxInCol[j] = Math.max(maxInCol[j], matrix[i][j]);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (minInRow[i] == maxInCol[j]) {
                        ans.add(minInRow[i]);
                    }
                }
            }
            return ans;
        }
    }
}
