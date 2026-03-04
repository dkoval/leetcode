package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/special-positions-in-a-binary-matrix/">Special Positions in a Binary Matrix</a>
 * <p>
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 * <p>
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == mat.length</li>
 *  <li>n == mat[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>mat[i][j] is either 0 or 1.</li>
 * </ul>
 */
public interface SpecialPositionsInBinaryMatrix {

    int numSpecial(int[][] mat);

    class SpecialPositionsInBinaryMatrixRev1 implements SpecialPositionsInBinaryMatrix {

        @Override
        public int numSpecial(int[][] mat) {
            final var m = mat.length;
            final var n = mat[0].length;

            final var row1s = new int[m];
            final var col1s = new int[n];
            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    row1s[i] += mat[i][j];
                    col1s[j] += mat[i][j];
                }
            }

            var count = 0;
            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    if (mat[i][j] == 1 && row1s[i] == 1 && col1s[j] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
