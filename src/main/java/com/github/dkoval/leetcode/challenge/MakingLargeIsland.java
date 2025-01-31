package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/making-a-large-island/">Making A Large Island (Hard)</a>
 * <p>
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 * <p>
 * Return the size of the largest island in grid after applying this operation.
 * <p>
 * An island is a 4-directionally connected group of 1s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= n <= 500</li>
 *  <li>grid[i][j] is either 0 or 1.</li>
 * </ul>
 */
public interface MakingLargeIsland {

    int largestIsland(int[][] grid);

    // O(N^2) time | O(1) space
    class MakingLargeIslandRev1 implements MakingLargeIsland {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int largestIsland(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            // pass #1: detect islands
            var maxArea = 0;
            // map island to its area
            var islandId = 2; // 0 - water, 1 - unvisited land
            final var areas = new HashMap<Integer, Integer>();
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        var area = traverse(grid, row, col, islandId);
                        maxArea = Math.max(maxArea, area);
                        areas.put(islandId++, area);
                    }
                }
            }

            // pass #2: connect islands to form a larger one
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    if (grid[row][col] != 0) {
                        continue;
                    }

                    // 1. flip (row, col) to 1
                    // 2. check adjacent cells to see if a larger island can be formed
                    var area = 1;
                    var seen = new HashSet<Integer>();
                    for (var d : DIRS) {
                        var nextRow = row + d[0];
                        var nextCol = col + d[1];

                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                            continue;
                        }

                        if (grid[nextRow][nextCol] > 1 && !seen.contains(grid[nextRow][nextCol])) {
                            area += areas.get(grid[nextRow][nextCol]);
                            seen.add(grid[nextRow][nextCol]);
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }

        private int traverse(int[][] grid, int row, int col, int islandId) {
            // DFS
            final var m = grid.length;
            final var n = grid[0].length;

            // mark (row, col) as visited
            grid[row][col] = islandId;
            var area = 1;
            for (var d : DIRS) {
                var nextRow = row + d[0];
                var nextCol = col + d[1];

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                if (grid[nextRow][nextCol] == 1) {
                    area += traverse(grid, nextRow, nextCol, islandId);
                }
            }
            return area;
        }
    }
}
