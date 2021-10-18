package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum/">Minimum Falling Path Sum</a>
 * <p>
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is
 * either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == matrix.length</li>
 *  <li>n == matrix[i].length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>-100 <= matrix[i][j] <= 100</li>
 * </ul>
 */
public class MinimumFallingPathSum {

    private static final int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}};

    // O(N^2) time | O(N^2) space
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // dp[i][j] is the minimum falling path sum
        int[][] dp = new int[n][n];
        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int prevMinSum = Integer.MAX_VALUE;
                for (int[] d : DIRECTIONS) {
                    int prevRow = row + d[0];
                    int prevCol = col + d[1];
                    if (prevRow < 0 || prevRow >= n || prevCol < 0 || prevCol >= n) {
                        continue;
                    }
                    prevMinSum = Math.min(prevMinSum, dp[prevRow][prevCol]);
                }
                dp[row][col] = matrix[row][col] + prevMinSum;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, dp[n - 1][col]);
        }
        return minSum;
    }
}
