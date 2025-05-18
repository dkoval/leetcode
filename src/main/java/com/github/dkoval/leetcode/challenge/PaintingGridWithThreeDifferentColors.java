package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/painting-a-grid-with-three-different-colors/">Painting a Grid With Three Different Colors (Hard)</a>
 * <p>
 * You are given two integers m and n. Consider an m x n grid where each cell is initially white. You can paint each cell red, green, or blue. All cells must be painted.
 * <p>
 * Return the number of ways to color the grid with no two adjacent cells having the same color. Since the answer can be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m <= 5</li>
 *  <li>1 <= n <= 1000</li>
 * </ul>
 */
public interface PaintingGridWithThreeDifferentColors {

    int MOD = 1_000_000_007;

    int colorTheGrid(int m, int n);

    class PaintingGridWithThreeDifferentColorsRev1 implements PaintingGridWithThreeDifferentColors {

        @Override
        public int colorTheGrid(int m, int n) {
            // precompute all possible column combinations (each row is of length m, where 1 <= m <= 5)
            final var cols = generateColumns(m);
            final var dp = new Integer[n][cols.size()];

            var total = 0;
            for (var i = 0; i < cols.size(); i++) {
                // for column 1, every other column is a valid previous column
                total += calc(1, i, n, cols, dp);
                total %= MOD;
            }
            return total;
        }

        private List<List<Integer>> generateColumns(int size) {
            final var ans = new ArrayList<List<Integer>>();
            backtrack(size, new ArrayList<>(), ans);
            return ans;
        }

        private void backtrack(int size, List<Integer> current, List<List<Integer>> ans) {
            if (current.size() == size) {
                ans.add(new ArrayList<>(current));
                return;
            }

            // consider 3 possible colors
            for (var x = 0; x < 3; x++) {
                if (current.isEmpty() || current.getLast() != x) {
                    current.add(x);
                    backtrack(size, current, ans);
                    current.removeLast();
                }
            }
        }

        // currCol - index of the current column to fill in, 1 <= col <= n
        // prevCol - index of a column in cols[] that is a valid previous column of `currCol`, 0 <= prevCol <= cols.size()
        private int calc(int currCol, int prevCol, int n, List<List<Integer>> cols, Integer[][] dp) {
            // base case
            if (currCol == n) {
                return 1;
            }

            // already solved?
            if (dp[currCol][prevCol] != null) {
                return dp[currCol][prevCol];
            }

            var total = 0;
            for (var i = 0; i < cols.size(); i++) {
                // the current column can be any cols[i] that doesn't conflict with the previous column
                if (valid(cols, i, prevCol)) {
                    // set cols[i] as the current column; cols[i] becomes the previous column in the next recursive call
                    total += calc(currCol + 1, i, n, cols, dp);
                    total %= MOD;
                }
            }
            return dp[currCol][prevCol] = total;
        }

        private boolean valid(List<List<Integer>> cols, int i, int j) {
            if (i == j) {
                return false;
            }

            final var xs = cols.get(i);
            final var ys = cols.get(j);
            for (var index = 0; index < xs.size(); index++) {
                if (Objects.equals(xs.get(index), ys.get(index))) {
                    return false;
                }
            }
            return true;
        }
    }
}
