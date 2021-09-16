package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3977/">Spiral Matrix</a>
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0, endRow = m - 1;
        int startCol = 0, endCol = n - 1;
        List<Integer> result = new ArrayList<>(m * n);

        while (startRow <= endRow && startCol <= endCol) {
            // top row - left to right
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
            startRow++;

            // right column - top to bottom
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;

            // bottom row - right to left
            for (int j = endCol; j >= startCol && startRow <= endRow; j--) {
                result.add(matrix[endRow][j]);
            }
            endRow--;

            // left column - bottom to top
            for (int i = endRow; i >= startRow && startCol <= endCol; i--) {
                result.add(matrix[i][startCol]);
            }
            startCol++;
        }
        return result;
    }
}
