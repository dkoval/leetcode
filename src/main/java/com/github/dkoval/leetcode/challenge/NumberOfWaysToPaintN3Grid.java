package com.github.dkoval.leetcode.challenge;

import java.util.List;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/">Number of Ways to Paint N × 3 Grid (Hard)</a>
 * <p>
 * You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors:
 * Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share
 * vertical or horizontal sides have the same color).
 * <p>
 * Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large,
 * the answer must be computed modulo 10^9 + 7.
 */
public interface NumberOfWaysToPaintN3Grid {

    int MOD = 1_000_000_007;

    int numOfWays(int n);

    class NumberOfWaysToPaintN3GridRev1 implements NumberOfWaysToPaintN3Grid {

        @Override
        public int numOfWays(int n) {
            // DP
            return calc(n, 0, List.of(-1, -1, -1), new Integer[n][4][4][4]);
        }

        private int calc(int n, int index, List<Integer> prevRow, Integer[][][][] dp) {
            // base case
            if (index == n) {
                return 1;
            }

            final var prevC1 = prevRow.get(0) + 1;
            final var prevC2 = prevRow.get(1) + 1;
            final var prevC3 = prevRow.get(2) + 1;

            // already solved?
            if (dp[index][prevC1][prevC2][prevC3] != null) {
                return dp[index][prevC1][prevC2][prevC3];
            }

            // consider all possibilities to fill the i-th row
            var total = 0;
            for (var c1 = 0; c1 < 3; c1++) {
                for (var c2 = 0; c2 < 3; c2++) {
                    for (var c3 = 0; c3 < 3; c3++) {
                        final var currRow = List.of(c1, c2, c3);
                        if (isValidState(currRow, prevRow)) {
                            total += calc(n, index + 1, currRow, dp);
                            total %= MOD;
                        }
                    }
                }
            }
            // cache and return the result
            return dp[index][prevC1][prevC2][prevC3] = total;
        }

        private boolean isValidState(List<Integer> currRow, List<Integer> prevRow) {
            // for each cell in the current row, check adjacent colors: to the left and above
            for (var i = 1; i < 3; i++) {
                if (Objects.equals(currRow.get(i), currRow.get(i - 1))) {
                    return false;
                }
            }

            for (var i = 0; i < 3; i++) {
                if (Objects.equals(currRow.get(i), prevRow.get(i))) {
                    return false;
                }
            }

            return true;
        }
    }
}
