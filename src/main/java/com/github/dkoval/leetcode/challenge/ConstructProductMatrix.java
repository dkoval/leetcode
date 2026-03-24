package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/construct-product-matrix/">Construct Product Matrix</a>
 * <p>
 * Given a 0-indexed 2D integer matrix grid of size n * m, we define a 0-indexed 2D matrix p of size n * m as
 * the product matrix of grid if the following condition is met:
 * <p>
 * Each element p[i][j] is calculated as the product of all elements in grid except for the element grid[i][j].
 * This product is then taken modulo 12345.
 * <p>
 * Return the product matrix of grid.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == grid.length <= 10^5</li>
 *  <li>1 <= m == grid[i].length <= 10^5</li>
 *  <li>2 <= n * m <= 10^5</li>
 *  <li>1 <= grid[i][j] <= 10^9</li>
 * </ul>
 */
public interface ConstructProductMatrix {

    int[][] constructProductMatrix(int[][] grid);

    class ConstructProductMatrixRev1 implements ConstructProductMatrix {

        int MOD = 12345;

        @Override
        public int[][] constructProductMatrix(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            // idea: for each (i, j) to exclude, maintain prefix and suffix products
            var prefix = 1;
            final var prefixes = new int[m][n];
            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    prefixes[i][j] = prefix;
                    prefix = multiply(grid[i][j], prefix);
                }
            }

            var suffix = 1;
            final var suffixes = new int[m][n];
            for (var i = m - 1; i >= 0; i--) {
                for (var j = n - 1; j >= 0; j--) {
                    suffixes[i][j] = suffix;
                    suffix = multiply(grid[i][j], suffix);
                }
            }

            final var res = new int[m][n];
            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    res[i][j] = multiply(prefixes[i][j], suffixes[i][j]);
                }
            }
            return res;
        }

        private int multiply(int x, int y) {
            return (int) (((long) x * y) % MOD);
        }
    }
}
