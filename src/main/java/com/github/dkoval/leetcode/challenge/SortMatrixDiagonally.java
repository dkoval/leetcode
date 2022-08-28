package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-the-matrix-diagonally/">Sort the Matrix Diagonally</a>
 * <p>
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and
 * going in the bottom-right direction until reaching the matrix's end.
 * For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 * <p>
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == mat.length</li>
 *  <li>n == mat[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>1 <= mat[i][j] <= 100</li>
 * </ul>
 */
public interface SortMatrixDiagonally {

    int[][] diagonalSort(int[][] mat);

    // O(M*N) time | O(M*N) space
    class SortMatrixDiagonallyRev1 implements SortMatrixDiagonally {

        @Override
        public int[][] diagonalSort(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            if (m == 1 || n == 1) {
                return mat;
            }

            // trivia #1: total number of diagonals in m x n matrix is (m + n - 1)
            // trivia #2: diagonal starts at an element for which either i = 0 or j = 0
            // matrix diagonal id -> diagonal elements
            Map<Integer, List<Integer>> diagonals = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int diagonalId = i - j;
                    diagonals.computeIfAbsent(diagonalId, key -> new ArrayList<>()).add(mat[i][j]);
                }
            }

            // diagonals starting at the 1st row
            for (int j = 0; j < n; j++) {
                // id = i - j, where i = 0
                List<Integer> items = diagonals.get(-j);
                Collections.sort(items);

                // fill the diagonal
                int row = 0;
                int col = j;
                for (int x : items) {
                    mat[row][col] = x;
                    row++;
                    col++;
                }
            }

            // diagonals starting the 1st column, excluding the one starting at (0, 0)
            for (int i = 1; i < m; i++) {
                // id = i - j, where j = 0
                List<Integer> items = diagonals.get(i);
                Collections.sort(items);

                // fill the diagonal
                int row = i;
                int col = 0;
                for (int x : items) {
                    mat[row][col] = x;
                    row++;
                    col++;
                }
            }

            return mat;
        }
    }
}
