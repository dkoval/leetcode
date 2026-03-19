package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/">Count Submatrices With Equal Frequency of X and Y</a>
 * <p>
 * Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:
 * <ul>
 *  <li>grid[0][0]</li>
 *  <li>an equal frequency of 'X' and 'Y'.</li>
 *  <li>at least one 'X'.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= grid.length, grid[i].length <= 1000</li>
 *  <li>grid[i][j] is either 'X', 'Y', or '.'.</li>
 * </ul>
 */
public interface CountSubmatricesWithEqualFrequencyOfXAndY {

    int numberOfSubmatrices(char[][] grid);

    class CountSubmatricesWithEqualFrequencyOfXAndYRev1 implements CountSubmatricesWithEqualFrequencyOfXAndY {

        @Override
        public int numberOfSubmatrices(char[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            // idea: 2D prefix sum
            var count = 0;
            final var prefixSum = new Counts[m][n];
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    final var xs = grid[row][col] == 'X' ? 1 : 0;
                    final var ys = grid[row][col] == 'Y' ? 1 : 0;

                    prefixSum[row][col] = new Counts(xs, ys);
                    if (row - 1 >= 0) {
                        prefixSum[row][col] = prefixSum[row][col].plus(prefixSum[row - 1][col]);
                    }

                    if (col - 1 >= 0) {
                        prefixSum[row][col] = prefixSum[row][col].plus(prefixSum[row][col - 1]);
                    }

                    // handle double counting of common intersection area
                    if (row - 1 >= 0 && col - 1 >= 0) {
                        prefixSum[row][col] = prefixSum[row][col].minus(prefixSum[row - 1][col - 1]);
                    }

                    if (prefixSum[row][col].xs >= 1 && prefixSum[row][col].xs == prefixSum[row][col].ys) {
                        count++;
                    }
                }
            }
            return count;
        }

        private record Counts(int xs, int ys) {

            Counts plus(Counts other) {
                return new Counts(xs + other.xs, ys + other.ys);
            }

            Counts minus(Counts other) {
                return new Counts(xs - other.xs, ys - other.ys);
            }
        }
    }
}
