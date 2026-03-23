package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/">Maximum Non Negative Product in a Matrix</a>
 * <p>
 * You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step,
 * you can only move right or down in the matrix.
 * <p>
 * Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1),
 * find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells
 * visited along the path.
 * <p>
 * Return the maximum non-negative product modulo 10^9 + 7. If the maximum product is negative, return -1.
 * <p>
 * Notice that the modulo is performed after getting the maximum product.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 15</li>
 *  <li>-4 <= grid[i][j] <= 4</li>
 * </ul>
 */
public interface MaximumNonNegativeProductInMatrix {

    int MOD = 1_000_000_007;

    int maxProductPath(int[][] grid);

    class MaximumNonNegativeProductInMatrixRev1 implements MaximumNonNegativeProductInMatrix {

        @Override
        public int maxProductPath(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var result = calc(grid, 0, 0, new Result[m][n]);
            return (result.maxProduct >= 0) ? (int) (result.maxProduct % MOD) : -1;
        }

        private Result calc(int[][] grid, int row, int col, Result[][] dp) {
            final var m = grid.length;
            final var n = grid[0].length;

            // base case
            if (row == m - 1 && col == n - 1) {
                return new Result(grid[row][col], grid[row][col]);
            }

            // already solved?
            if (dp[row][col] != null) {
                return dp[row][col];
            }

            final var products = new ArrayList<Long>();

            // go right
            if (col + 1 < n) {
                final var result = calc(grid, row, col + 1, dp);
                products.add(grid[row][col] * result.maxProduct);
                products.add(grid[row][col] * result.minProduct);
            }

            // go down
            if (row + 1 < m) {
                final var result = calc(grid, row + 1, col, dp);
                products.add(grid[row][col] * result.maxProduct);
                products.add(grid[row][col] * result.minProduct);
            }

            return dp[row][col] = new Result(maxOf(products), minOf(products));
        }

        private long maxOf(List<Long> nums) {
            var best = Long.MIN_VALUE;
            for (var x : nums) {
                best = Math.max(best, x);
            }
            return best;
        }

        private long minOf(List<Long> nums) {
            var best = Long.MAX_VALUE;
            for (var x : nums) {
                best = Math.min(best, x);
            }
            return best;
        }

        private record Result(
                long maxProduct,
                long minProduct
        ) {
        }
    }
}
