package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
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
public interface PathWithMinimumEffort {

    int minimumEffortPath(int[][] heights);

    class PathWithMinimumEffortRev1 implements PathWithMinimumEffort {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public int minimumEffortPath(int[][] heights) {
            // binary search on effort
            int left = 0;
            int right = max(heights);
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (possibleHike(heights, mid)) {
                    // mid is a potential answer
                    // can we find a better solution to the left of `mid`?
                    right = mid;
                } else {
                    // mid is not an answer
                    // skip everything to the left of `mid`, including `mid` itself
                    left = mid + 1;
                }
            }
            return left;
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
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    // already visited?
                    if (visited[nextRow][nextCol]) {
                        continue;
                    }

                    // can take curr -> next edge?
                    if (Math.abs(heights[nextRow][nextCol] - heights[curr.row][curr.col]) > effort) {
                        continue;
                    }

                    q.offer(new Cell(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
            return false;
        }

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }

    class PathWithMinimumEffortRev2 implements PathWithMinimumEffort {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;

            // corner case
            if (rows == 1 && cols == 1) {
                return 0;
            }

            // binary search the absolute difference in heights between two consecutive cells of the route
            // FF...FTT...T
            //       ^ answer
            // constraints: 1 <= heights[i][j] <= 10^6
            int left = 0;
            int right = 1_000_000 - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canGo(heights, mid)) {
                    // mid might be the answer;
                    // check if there's a better option to the left of mid
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        // Checks whether it is possible to go from (0, 0) to (rows - 1, cols - 1) using only edges of ≤ threshold cost
        private boolean canGo(int[][] heights, int threshold) {
            int rows = heights.length;
            int cols = heights[0].length;

            // BFS
            Queue<Cell> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[rows][cols];
            q.offer(new Cell(0, 0));
            visited[0][0] = true;
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                        continue;
                    }

                    // already visited?
                    if (visited[nextRow][nextCol]) {
                        continue;
                    }

                    // can take curr -> next edge?
                    if (Math.abs(heights[curr.row][curr.col] - heights[nextRow][nextCol]) <= threshold) {
                        if (nextRow == rows - 1 && nextCol == cols - 1) {
                            return true;
                        }

                        q.offer(new Cell(nextRow, nextCol));
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            return false;
        }

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }

    class PathWithMinimumEffortRev3 implements PathWithMinimumEffort {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;

            // Dijkstra's algorithm
            Queue<Cell> q = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.effort));
            boolean[][] visited = new boolean[rows][cols];

            q.offer(new Cell(0, 0, 0));
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                if (curr.row == rows - 1 && curr.col == cols - 1) {
                    return curr.effort;
                }

                if (visited[curr.row][curr.col]) {
                    continue;
                }

                visited[curr.row][curr.col] = true;
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                        continue;
                    }

                    // already visited?
                    if (visited[nextRow][nextCol]) {
                        continue;
                    }

                    int diff = Math.abs(heights[nextRow][nextCol] - heights[curr.row][curr.col]);
                    q.offer(new Cell(nextRow, nextCol, Math.max(curr.effort, diff)));
                }
            }
            return -1;
        }

        private static class Cell {
            final int row;
            final int col;
            final int effort; // the maximum absolute difference in heights between two consecutive cells of the route.

            Cell(int row, int col, int effort) {
                this.row = row;
                this.col = col;
                this.effort = effort;
            }
        }
    }
}
