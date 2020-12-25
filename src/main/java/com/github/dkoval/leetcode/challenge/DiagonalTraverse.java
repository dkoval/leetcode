package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3580/">Diagonal Traverse</a>
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order.
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];
        int i = 0;
        int row = 0, col = 0;
        boolean up = true;
        while (row < m && col < n) {
            if (up) {
                while (row > 0 && col < n - 1) {
                    result[i++] = matrix[row][col];
                    row--;
                    col++;
                }
                result[i++] = matrix[row][col];
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (row < m - 1 && col > 0) {
                    result[i++] = matrix[row][col];
                    row++;
                    col--;
                }
                result[i++] = matrix[row][col];
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }
        return result;
    }
}
