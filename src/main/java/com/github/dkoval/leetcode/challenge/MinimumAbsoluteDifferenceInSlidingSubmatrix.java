package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/">Minimum Absolute Difference in Sliding Submatrix</a>
 * <p>
 * You are given an m x n integer matrix grid and an integer k.
 * <p>
 * For every contiguous k x k submatrix of grid, compute the minimum absolute difference between any two distinct values within that submatrix.
 * <p>
 * Return a 2D array ans of size (m - k + 1) x (n - k + 1), where ans[i][j] is the minimum absolute difference in the submatrix whose top-left corner is (i, j) in grid.
 * <p>
 * Note: If all elements in the submatrix have the same value, the answer will be 0.
 * <p>
 * A submatrix (x1, y1, x2, y2) is a matrix that is formed by choosing all cells matrix[x][y] where x1 <= x <= x2 and y1 <= y <= y2.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m == grid.length <= 30</li>
 *  <li>1 <= n == grid[i].length <= 30</li>
 *  <li>-10^5 <= grid[i][j] <= 10^5</li>
 *  <li>1 <= k <= min(m, n)</li>
 * </ul>
 */
public interface MinimumAbsoluteDifferenceInSlidingSubmatrix {

    int[][] minAbsDiff(int[][] grid, int k);

    class MinimumAbsoluteDifferenceInSlidingSubmatrixRev1 implements MinimumAbsoluteDifferenceInSlidingSubmatrix {

        @Override
        public int[][] minAbsDiff(int[][] grid, int k) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var ans = new int[m - k + 1][n - k + 1];
            for (var i = 0; i <= m - k; i++) {
                for (var j = 0; j <= n - k; j++) {
                    ans[i][j] = process(grid, k, i, j);
                }
            }
            return ans;
        }

        private int process(int[][] grid, int k, int startRow, int startCol) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var seen = new HashSet<Integer>();
            for (var i = startRow; i < startRow + k; i++) {
                for (var j = startCol; j < startCol + k; j++) {
                    if (seen.contains(grid[i][j])) {
                        continue;
                    }
                    seen.add(grid[i][j]);
                }
            }

            if (seen.size() == 1) {
                return 0;
            }

            final var distinct = new ArrayList<>(seen);
            Collections.sort(distinct);

            var best = Integer.MAX_VALUE;
            for (var i = 1; i < distinct.size(); i++) {
                best = Math.min(best, distinct.get(i) - distinct.get(i - 1));
            }
            return best;
        }
    }
}
