package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/">Spiral Matrix II</a>
 * <p>
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int numCircles = (n + 1) / 2;
        int x = 1;
        for (int c = 0; c < numCircles; c++) {
            // top row  - left to right
            for (int j = c; j < n - c; j++) {
                matrix[c][j] = x++;
            }
            // right column - top to bottom
            for (int i = c + 1; i < n - c; i++) {
                matrix[i][n - c - 1] = x++;
            }
            // bottom row - right to left
            for (int j = n - c - 2; j >= c; j--) {
                matrix[n - c - 1][j] = x++;
            }
            // left column - bottom to up
            for (int i = n - c - 2; i > c; i--) {
                matrix[i][c] = x++;
            }
        }
        return matrix;
    }
}
