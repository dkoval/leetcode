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

        List<Integer> ans = new ArrayList<>(m * n);
        while (startRow <= endRow && startCol <= endCol) {
            // top row
            for (int j = startCol; j <= endCol; j++) {
                ans.add(matrix[startRow][j]);
            }

            // right column
            for (int i = startRow + 1; i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
            }

            // bottom row
            for (int j = endCol - 1; j >= startCol && startRow < endRow; j--) {
                ans.add(matrix[endRow][j]);
            }

            // left column
            for (int i = endRow - 1; i > startRow && startCol < endCol; i--) {
                ans.add(matrix[i][startCol]);
            }

            startRow++;
            endRow--;

            startCol++;
            endCol--;
        }
        return ans;
    }
}
