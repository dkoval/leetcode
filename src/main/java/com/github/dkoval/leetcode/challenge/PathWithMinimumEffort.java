package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/path-with-minimum-effort/">Path With Minimum Effort</a>
 * <p>
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
 * and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
 * You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * <p>
 * Constraints:
 * <ul>
 *  <li>rows == heights.length</li>
 *  <li>columns == heights[i].length</li>
 *  <li>1 <= rows, columns <= 100</li>
 *  <li>1 <= heights[i][j] <= 10^6</li>
 * </ul>
 */
public class PathWithMinimumEffort {

    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static class Cell {
        final int row;
        final int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        // binary search on effort
        int l = 0;
        int r = max(heights);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (possibleHike(heights, mid)) {
                // mid is a potential answer
                // can we find a better solution to the left of `mid`?
                r = mid;
            } else {
                // mid is not an answer
                // skip everything to the left of `mid`, including `mid` itself
                l = mid + 1;
            }
        }
        return l;
    }

    private int max(int[][] nums) {
        int ans = Integer.MIN_VALUE;
        for (int[] row : nums) {
            for (int x : row) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }

    private boolean possibleHike(int[][] heights, int effort) {
        int m = heights.length;
        int n = heights[0].length;

        // BFS
        Queue<Cell> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(new Cell(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Cell curr = q.poll();
            if (curr.row == m - 1 && curr.col == n - 1) {
                return true;
            }

            // explore adjacent cells
            for (int[] d : DIRECTIONS) {
                int nextRow = curr.row + d[0];
                int nextCol = curr.col + d[1];

                // check boundaries?
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                // already visited?
                if (visited[nextRow][nextCol]) {
                    continue;
                }

                // is next cell good at all?
                if (Math.abs(heights[nextRow][nextCol] - heights[curr.row][curr.col]) > effort) {
                    continue;
                }

                q.offer(new Cell(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }
        }
        return false;
    }
}
