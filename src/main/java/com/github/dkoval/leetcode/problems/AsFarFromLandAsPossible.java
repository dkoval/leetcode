package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/as-far-from-land-as-possible/">As Far from Land as Possible</a>
 * <p>
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell
 * such that its distance to the nearest land cell is maximized, and return the distance.
 * If no land or water exists in the grid, return -1.
 * <p>
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>grid[i][j] is 0 or 1</li>
 * </ul>
 */
public interface AsFarFromLandAsPossible {

    int maxDistance(int[][] grid);

    // TLE
    class AsFarFromLandAsPossibleBruteForce implements AsFarFromLandAsPossible {

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        @Override
        public int maxDistance(int[][] grid) {
            int n = grid.length;

            List<Cell> lands = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        lands.add(new Cell(row, col));
                    }
                }
            }

            if (lands.isEmpty()) {
                return -1;
            }

            int maxDist = -1;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 0) {
                        // distance from a water cell grid[row][col] to the nearest land
                        int dist = minDistance(new Cell(row, col), lands);
                        maxDist = Math.max(maxDist, dist);
                    }
                }
            }
            return maxDist;
        }

        private int minDistance(Cell from, List<Cell> target) {
            int dist = Integer.MAX_VALUE;
            for (Cell to : target) {
                dist = Math.min(dist, Math.abs(from.row - to.row) + Math.abs(from.col - to.col));
            }
            return dist;
        }
    }

    class AsFarFromLandAsPossibleBFSRev1 implements AsFarFromLandAsPossible {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // O(N^2) time | O(N^2) space
        @Override
        public int maxDistance(int[][] grid) {
            int n = grid.length;

            // idea: multi-source BFS
            Queue<Cell> q = new ArrayDeque<>();
            // dists[row][col] - distance to the closest land from (row, col)
            Integer[][] dists = new Integer[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        q.offer(new Cell(row, col));
                        dists[row][col] = 0;
                    }
                }
            }

            if (q.isEmpty() || q.size() == n * n) {
                return -1;
            }

            int best = -1;
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    // (nextRow, nextCol) must be an unvisited water cell
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0 && dists[nextRow][nextCol] == null) {
                        q.offer(new Cell(nextRow, nextCol));
                        dists[nextRow][nextCol] = dists[curr.row][curr.col] + 1;
                        best = Math.max(best, dists[nextRow][nextCol]);
                    }
                }
            }
            return best;
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

    class AsFarFromLandAsPossibleBFSRev2 implements AsFarFromLandAsPossible {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        // Good reading: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/as_far_from_land_as_possible/topic
        // O(N^2) time | O(N^2) as we are initially storing the 1s present in the matrix
        @Override
        public int maxDistance(int[][] grid) {
            int n = grid.length;

            // Idea: instead of applying BFS on each 0 in the matrix, we will apply BFS on the 1's simultaneously
            Queue<Cell> q = new ArrayDeque<>();
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        q.offer(new Cell(row, col));
                    }
                }
            }

            if (q.isEmpty() || q.size() == n * n) {
                return -1;
            }

            int dist = -1;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    Cell curr = q.poll();
                    for (int[] d : DIRS) {
                        int nextRow = curr.row + d[0];
                        int nextCol = curr.col + d[1];

                        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] != 0) {
                            continue;
                        }

                        // mark as visited
                        grid[nextRow][nextCol] = 2;
                        q.offer(new Cell(nextRow, nextCol));
                    }
                }
                dist++;
            }
            return dist;
        }
    }
}
