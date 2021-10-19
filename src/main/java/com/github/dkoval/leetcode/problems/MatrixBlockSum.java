package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/matrix-block-sum/">Matrix Block Sum</a>
 * <p>
 * Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
 * <p>
 * i - k <= r <= i + k,
 * j - k <= c <= j + k, and
 * (r, c) is a valid position in the matrix.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == mat.length</li>
 *  <li>n == mat[i].length</li>
 *  <li>1 <= m, n, k <= 100</li>
 *  <li>1 <= mat[i][j] <= 100</li>
 * </ul>
 */
public class MatrixBlockSum {

    // O(M * N) time | O(M * N) space
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // sum[i][i] is the sum of elements in a rectangle defined by its
        // (0, 0) - upper left and (i, j) - bottom right corners
        int[][] sum = calcSum(mat);

        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = blockSum(sum, Math.max(i - k, 0), Math.max(j - k, 0), Math.min(i + k, m - 1), Math.min(j + k, n - 1));
            }
        }
        return ans;
    }

    private int[][] calcSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m][n];

        // prefix sum for each row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = mat[i][j] + (j > 0 ? sum[i][j - 1] : 0);
            }
        }

        // prefix sum for each column
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        return sum;
    }

    private int blockSum(int[][] sum, int startRow, int startCol, int endRow, int endCol) {
        return getSum(sum, endRow, endCol)
                - getSum(sum, endRow, startCol - 1)
                - getSum(sum, startRow - 1, endCol)
                + getSum(sum, startRow - 1, startCol - 1);
    }

    private int getSum(int[][] sum, int row, int col) {
        int m = sum.length;
        int n = sum[0].length;

        // boundary check
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        return sum[row][col];
    }
}
