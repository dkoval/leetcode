package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/detect-cycles-in-2d-grid/">Detect Cycles in 2D Grid</a>
 * <p>
 * Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
 * <p>
 * A cycle is a path of length 4 or more in the grid that starts and ends at the same cell.
 * From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right),
 * if it has the same value of the current cell.
 * <p>
 * Also, you cannot move to the cell that you visited in your last move.
 * For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
 * <p>
 * Return true if any cycle of the same value exists in grid, otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 500</li>
 *  <li>grid consists only of lowercase English letters.</li>
 * </ul>
 */
public interface DetectCyclesIn2DGrid {

    boolean containsCycle(char[][] grid);

    class DetectCyclesIn2DGridRev1 implements DetectCyclesIn2DGrid {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public boolean containsCycle(char[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var visited = new HashSet<Cell>();
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    final var current = new Cell(row, col);
                    if (visited.contains(current)) {
                        continue;
                    }

                    if (traverse(current, grid, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean traverse(Cell source, char[][] grid, Set<Cell> visited) {
            final var m = grid.length;
            final var n = grid[0].length;

            // DFS
            final var q = new ArrayDeque<Node>();
            q.offer(new Node(source, null));
            visited.add(source);
            while (!q.isEmpty()) {
                final var node = q.poll();
                for (var d : DIRS) {
                    final var next = node.current.next(d[0], d[1]);

                    if (!next.inBounds(m, n)) {
                        continue;
                    }

                    if (grid[next.row][next.col] != grid[source.row][source.col]) {
                        continue;
                    }

                    if (next.equals(node.parent)) {
                        continue;
                    }

                    if (next.equals(source)) {
                        return true;
                    }

                    q.offer(new Node(next, node.current));
                    visited.add(next);
                }
            }
            return false;
        }

        private record Cell(int row, int col) {

            public Cell next(int drow, int dcol) {
                return new Cell(row + drow, col + dcol);
            }

            public boolean inBounds(int m, int n) {
                return (row >= 0 && row < m) && (col >= 0 && col < n);
            }
        }

        private record Node(Cell current, Cell parent) {
        }
    }
}
