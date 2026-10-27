package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/create-grid-with-exactly-one-path/">Create Grid With Exactly One Path</a>
 * <p>
 * You are given two integers m and n, representing the number of rows and columns of a grid.
 * <p>
 * Construct any m x n grid consisting only of the characters '.' and '#', where:
 * <p>
 * '.' represents a free cell.
 * '#' represents an obstacle cell.
 * A valid path is a sequence of free cells that:
 * <p>
 * Starts at the top-left cell (0, 0).
 * <p>
 * Ends at the bottom-right cell (m - 1, n - 1).
 * <p>
 * Moves only:
 * <p>
 * Right, from (i, j) to (i, j + 1), or
 * <p>
 * Down, from (i, j) to (i + 1, j).
 * <p>
 * Return any grid such that there is exactly one valid path from the top-left cell to the bottom-right cell.
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 25
 */
public interface CreateGridWithExactlyOnePath {

    String[] createGrid(int m, int n);

    class CreateGridWithExactlyOnePathRev1 implements CreateGridWithExactlyOnePath {

        @Override
        public String[] createGrid(int m, int n) {
            final var res = new String[m];
            for (var i = 0; i < m; i++) {
                res[i] = row(i, n);
            }
            return res;
        }

        private String row(int i, int n) {
            final var sb = new StringBuilder();
            for (var j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            return sb.toString();
        }
    }
}
