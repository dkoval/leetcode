package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/">Minimum Obstacle Removal to Reach Corner</a>
 * <p>
 * You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:
 * <ul>
 *  <li>0 represents an empty cell,</li>
 *  <li>1 represents an obstacle that may be removed.</li>
 * </ul>
 * You can move up, down, left, or right from and to an empty cell.
 * <p>
 * Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 10^5</li>
 *  <li>2 <= m * n <= 10^5</li>
 *  <li>grid[i][j] is either 0 or 1.</li>
 *  <li>grid[0][0] == grid[m - 1][n - 1] == 0</li>
 * </ul>
 */
public interface MinimumObstacleRemovalToReachCorner {

    int minimumObstacles(int[][] grid);

    class MinimumObstacleRemovalToReachCornerRev1 implements MinimumObstacleRemovalToReachCorner {

        // up, down,left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int minimumObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // Costs:
            // empty cel - 0
            // obstacle  - 1

            // Dijkstra's algorithm to find the shortest path between 2 cells in a weighted graph
            Queue<Cell> q = new PriorityQueue<>(Comparator.comparingInt(it -> it.cost));
            Integer[][] costs = new Integer[m][n];

            // grid[row][col] is either 0 or 1
            costs[0][0] = grid[0][0];
            q.offer(new Cell(costs[0][0], 0, 0));

            while (!q.isEmpty()) {
                Cell curr = q.poll();

                if (curr.row == m - 1 && curr.col == n - 1) {
                    return curr.cost;
                }

                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    // ignore neighbour cells having greater cost
                    int nextCost = costs[curr.row][curr.col] + grid[nextRow][nextCol];
                    if (costs[nextRow][nextCol] == null || nextCost < costs[nextRow][nextCol]) {
                        costs[nextRow][nextCol] = nextCost;
                        q.offer(new Cell(nextCost, nextRow, nextCol));
                    }
                }
            }
            return costs[m - 1][n - 1];
        }

        private record Cell(int cost, int row, int col) {
        }
    }

    class MinimumObstacleRemovalToReachCornerRev2 implements MinimumObstacleRemovalToReachCorner {

        // up, down,left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int minimumObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // Costs:
            // empty cel - 0
            // obstacle  - 1

            // 0-1 BFS to find the shortest path between 2 cells in a weighted graph
            Deque<Cell> q = new ArrayDeque<>();
            Integer[][] costs = new Integer[m][n];

            // grid[0][0] == grid[m - 1][n - 1] == 0
            q.offerFirst(new Cell(0, 0));
            costs[0][0] = 0;
            while (!q.isEmpty()) {
                Cell curr = q.pollFirst();

                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    // already visited?
                    if (costs[nextRow][nextCol] != null) {
                        continue;
                    }

                    // grid[nextRow][nextCol] is either 0 or 1
                    int nextCost = costs[curr.row][curr.col] + grid[nextRow][nextCol];
                    costs[nextRow][nextCol] = nextCost;

                    // 0-1 trick
                    Cell nextCell = new Cell(nextRow, nextCol);
                    if (grid[nextRow][nextCol] == 0) {
                        // empty cells (add no cost) get processed prior to the obstacles in the next iteration
                        q.offerFirst(nextCell);
                    } else {
                        // obstacles (increase the total cost) get processed after the empty cells
                        q.offerLast(nextCell);
                    }
                }
            }
            return costs[m - 1][n - 1];
        }

        private record Cell(int row, int col) {
        }
    }
}
