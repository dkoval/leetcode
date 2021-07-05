package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3803/">Reshape the Matrix</a>
 * <p>
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different
 * size r x c keeping its original data.
 * <p>
 * You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted
 * reshaped matrix.
 * <p>
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as
 * they were.
 * <p>
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix;
 * Otherwise, output the original matrix
 */
public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] matrix, int r, int c) {
        int origR = matrix.length;
        int origC = matrix[0].length;
        if (r * c != origR * origC) {
            return matrix;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // convert to 1D coordinate
                int p = i * c + j;
                // map (i, j) to (row, col) in the original matrix
                int row = p / origC;
                int col = p % origC;
                result[i][j] = matrix[row][col];
            }
        }
        return result;
    }
}
