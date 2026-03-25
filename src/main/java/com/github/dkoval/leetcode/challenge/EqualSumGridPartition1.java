package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/equal-sum-grid-partition-i/">Equal Sum Grid Partition I</a>
 * <p>
 * You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make
 * either one horizontal or one vertical cut on the grid such that:
 * <p>
 * Each of the two resulting sections formed by the cut is non-empty.
 * <p>
 * The sum of the elements in both sections is equal.
 * <p>
 * Return true if such a partition exists; otherwise return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m == grid.length <= 10^5</li>
 *  <li>1 <= n == grid[i].length <= 10^5</li>
 *  <li>2 <= m * n <= 10^5</li>
 *  <li>1 <= grid[i][j] <= 10^5</li>
 * </ul>
 */
public interface EqualSumGridPartition1 {

    boolean canPartitionGrid(int[][] grid);

    class EqualSumGridPartition1Rev1 implements EqualSumGridPartition1 {

        @Override
        public boolean canPartitionGrid(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var totalSum = sumOf(grid);

            // inspect rows
            var rowSum = 0L;
            for (var i = 0; i < m - 1; i++) {
                for (var j = 0; j < n; j++) {
                    rowSum += grid[i][j];
                }

                if (rowSum == totalSum - rowSum) {
                    return true;
                }
            }

            // inspect columns
            var colSum = 0L;
            for (var j = 0; j < n - 1; j++) {
                for (var i = 0; i < m; i++) {
                    colSum += grid[i][j];
                }

                if (colSum == totalSum - colSum) {
                    return true;
                }
            }

            return false;
        }

        private long sumOf(int[][] grid) {
            var sum = 0L;
            for (var row : grid) {
                for (var x : row) {
                    sum += x;
                }
            }
            return sum;
        }
    }
}
