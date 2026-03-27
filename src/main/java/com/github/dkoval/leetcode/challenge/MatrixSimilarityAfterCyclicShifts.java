package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/">Matrix Similarity After Cyclic Shifts</a>
 * <p>
 * You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.
 * <p>
 * The following process happens k times:
 * <p>
 * Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.
 * <p>
 * Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.
 * <p>
 * Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= mat.length <= 25</li>
 *  <li>1 <= mat[i].length <= 25</li>
 *  <li>1 <= mat[i][j] <= 25</li>
 *  <li>1 <= k <= 50</li>
 * </ul>
 */
public interface MatrixSimilarityAfterCyclicShifts {

    boolean areSimilar(int[][] mat, int k);

    class MatrixSimilarityAfterCyclicShiftsRev1 implements MatrixSimilarityAfterCyclicShifts {

        @Override
        public boolean areSimilar(int[][] mat, int k) {
            final var m = mat.length;
            final var n = mat[0].length;

            // after n shifts, the matrix is back to the original state
            k %= n;

            // corner case
            if (k == 0) {
                return true;
            }

            // run simulation
            var copy = copy(mat);
            for (var i = 0; i < m; i++) {
                if (i % 2 == 0) {
                    cyclicShiftLeft(copy[i], k);
                } else {
                    cyclicShiftRight(copy[i], k);
                }
            }
            return areSame(mat, copy);
        }

        private int[][] copy(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var copy = new int[m][n];
            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    copy[i][j] = grid[i][j];
                }
            }
            return copy;
        }

        private void cyclicShiftLeft(int[] arr, int times) {
            final var n = arr.length;
            while (times-- > 0) {
                final var first = arr[0];
                for (var i = 0; i < n - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[n - 1] = first;
            }
        }

        private void cyclicShiftRight(int[] arr, int times) {
            final var n = arr.length;
            while (times-- > 0) {
                final var last = arr[n - 1];
                for (var i = n - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = last;
            }
        }

        private boolean areSame(int[][] actual, int[][] expected) {
            final var m = actual.length;
            for (var i = 0; i < m; i++) {
                if (!Arrays.equals(actual[i], expected[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    class MatrixSimilarityAfterCyclicShiftsRev2 implements MatrixSimilarityAfterCyclicShifts {

        @Override
        public boolean areSimilar(int[][] mat, int k) {
            final var m = mat.length;
            final var n = mat[0].length;

            // after n shifts, the matrix is back to the original state
            k = k % n;

            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    if (mat[i][j] != mat[i][(i % 2 == 0) ? (j + k) % n : (j - k + n) % n]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
