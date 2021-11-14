package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/">Spiral Matrix II</a>
 * <p>
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int startRow = 0;
        int endRow = n - 1;

        int startCol = 0;
        int endCol = n - 1;

        int x = 1;
        int[][] ans = new int[n][n];
        while (startRow <= endRow && startCol <= endCol) {
            // top row  - left to right
            for (int col = startCol; col <= endCol; col++) {
                ans[startRow][col] = x++;
            }

            // right column - top to bottom
            for (int row = startRow + 1; row <= endRow; row++) {
                ans[row][endCol] = x++;
            }

            // bottom row - right to left
            for (int col = endCol - 1; col >= startCol; col--) {
                ans[endRow][col] = x++;
            }

            // left column - bottom to up
            for (int row = endRow - 1; row > startRow; row--) {
                ans[row][startCol] = x++;
            }

            startRow++;
            endRow--;

            startCol++;
            endCol--;
        }
        return ans;
    }
}
