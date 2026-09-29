package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/">Check if There Is a Valid Parentheses String Path</a>
 * <p>
 * A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:
 * <ul>
 *  <li>It is ().</li>
 *  <li>It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.</li>
 *  <li>It can be written as (A), where A is a valid parentheses string.</li>
 * </ul>
 * You are given an m x n matrix of parentheses grid. A valid parentheses string path in the grid is a path satisfying all of the following conditions:
 * <ul>
 *  <li>The path starts from the upper left cell (0, 0).</li>
 *  <li>The path ends at the bottom-right cell (m - 1, n - 1).</li>
 *  <li>The path only ever moves down or right.</li>
 *  <li>The resulting parentheses string formed by the path is valid.</li>
 * </ul>
 * Return true if there exists a valid parentheses string path in the grid. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>grid[i][j] is either '(' or ')'</li>
 * </ul>
 */
public interface CheckIfThereIsValidParenthesesStringPath {

    boolean hasValidPath(char[][] grid);

    class CheckIfThereIsValidParenthesesStringPathRev1 implements CheckIfThereIsValidParenthesesStringPath {

        private static final int[][] DIRS = {{1, 0}, {0, 1}};

        @Override
        public boolean hasValidPath(char[][] grid) {
            // DP: top-down
            var open = delta(grid, 0, 0, '(');
            var close = delta(grid, 0, 0, ')');
            return calc(grid, 0, 0, open, close, new HashMap<>());
        }

        private boolean calc(char[][] grid, int row, int col, int open, int close, Map<Key, Boolean> dp) {
            final var m = grid.length;
            final var n = grid[0].length;

            // base case
            if (row == m - 1 && col == n - 1) {
                return (grid[row][col] == ')') && (open == close);
            }

            // already solved?
            var key = new Key(row, col, open, close);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            var res = false;
            for (var d : DIRS) {
                var nextRow = row + d[0];
                var nextCol = col + d[1];

                if (nextRow == m || nextCol == n) {
                    continue;
                }

                var nextOpen = open + delta(grid, nextRow, nextCol, '(');
                var nextClose = close + delta(grid, nextRow, nextCol, ')');

                if (nextOpen >= nextClose) {
                    res |= calc(grid, nextRow, nextCol, nextOpen, nextClose, dp);
                    if (res) {
                        break;
                    }
                }
            }

            // cache and return the result
            dp.put(key, res);
            return res;
        }

        private int delta(char[][] grid, int row, int col, char target) {
            return (grid[row][col] == target) ? 1 : 0;
        }

        private record Key(
                int row,
                int col,
                int open,
                int close
        ) {
        }
    }
}
