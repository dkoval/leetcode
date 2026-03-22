package com.github.dkoval.leetcode.problems;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/">Determine Whether Matrix Can Be Obtained By Rotation</a>
 * <p>
 * Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == mat.length == target.length</li>
 *  <li>n == mat[i].length == target[i].length</li>
 *  <li>1 <= n <= 10</li>
 *  <li>mat[i][j] and target[i][j] are either 0 or 1</li>
 * </ul>
 */
public interface DetermineWhetherMatrixCanBeObtainedByRotation {

    boolean findRotation(int[][] mat, int[][] target);

    class DetermineWhetherMatrixCanBeObtainedByRotationRev1 implements DetermineWhetherMatrixCanBeObtainedByRotation {

        @Override
        public boolean findRotation(int[][] mat, int[][] target) {
            for (var t = 1; t <= 4; t++) {
                final var actual = rotate90Clockwise(mat);
                if (arrayEquals(actual, target)) {
                    return true;
                }
            }
            return false;
        }

        private int[][] rotate90Clockwise(int[][] mat) {
            final var n = mat.length;
            transpose(mat);
            for (var row = 0; row < n; row++) {
                // reverse each row
                var left = 0;
                var right = n - 1;
                while (left < right) {
                    var tmp = mat[row][left];
                    mat[row][left++] = mat[row][right];
                    mat[row][right--] = tmp;
                }
            }
            return mat;
        }

        private void transpose(int[][] mat) {
            final var n = mat.length;
            for (var row = 0; row < n; row++) {
                for (int col = 0; col < row; col++) {
                    var tmp = mat[row][col];
                    mat[row][col] = mat[col][row];
                    mat[col][row] = tmp;
                }
            }
        }

        private boolean arrayEquals(int[][] actual, int[][] expected) {
            final var n = actual.length;
            for (int row = 0; row < n; row++) {
                if (!Arrays.equals(actual[row], expected[row])) {
                    return false;
                }
            }
            return true;
        }
    }
}
