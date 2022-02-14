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
public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int t = 1; t <= 4; t++) {
            mat = rotate90Clockwise(mat);
            if (same(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private void transpose(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }

    private int[][] rotate90Clockwise(int[][] mat) {
        transpose(mat);
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            // reverse each row
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int tmp = mat[i][l];
                mat[i][l++] = mat[i][r];
                mat[i][r--] = tmp;
            }
        }
        return mat;
    }

    private boolean same(int[][] source, int[][] target) {
        int n = source.length;
        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(source[i], target[i])) {
                return false;
            }
        }
        return true;
    }
}
