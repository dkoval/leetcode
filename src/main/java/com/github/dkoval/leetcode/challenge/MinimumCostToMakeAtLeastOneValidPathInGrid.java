package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/">Minimum Cost to Make at Least One Valid Path in a Grid (Hard)</a>
 * <p>
 * Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell.
 * The sign of grid[i][j] can be:
 * <ul>
 *  <li>1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])</li>
 *  <li>2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])</li>
 *  <li>3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])</li>
 *  <li>4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])</li>
 * </ul>
 * Notice that there could be some signs on the cells of the grid that point outside the grid.
 * <p>
 * You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from
 * the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid.
 * The valid path does not have to be the shortest.
 * <p>
 * You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
 * <p>
 * Return the minimum cost to make the grid have at least one valid path.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>1 <= grid[i][j] <= 4</li>
 * </ul>
 */
public interface MinimumCostToMakeAtLeastOneValidPathInGrid {

    int minCost(int[][] grid);

    class MinimumCostToMakeAtLeastOneValidPathInGridRev1 implements MinimumCostToMakeAtLeastOneValidPathInGrid {

        @Override
        public int minCost(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            // Dijkstra's algorithm
            final var q = new PriorityQueue<Cell>(Comparator.comparingInt(it -> it.cost));

            final var costs = new int[m][n];
            for (var items : costs) {
                Arrays.fill(items, Integer.MAX_VALUE);
            }

            q.offer(new Cell(0, 0, 0));
            while (!q.isEmpty()) {
                var curr = q.poll();
                costs[curr.row][curr.col] = curr.cost;

                if (curr.row == m - 1 && curr.col == n - 1) {
                    return curr.cost;
                }

                for (Direction d : Direction.values()) {
                    final var nextRow = curr.row + d.drow;
                    final var nextCol = curr.col + d.dcol;

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    final var delta = (d.sign == grid[curr.row][curr.col]) ? 0 : 1;
                    if (curr.cost + delta < costs[nextRow][nextCol]) {
                        q.offer(new Cell(nextRow, nextCol, curr.cost + delta));
                        costs[nextRow][nextCol] = curr.cost + delta;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }

        private enum Direction {
            RIGHT(0, 1, 1),
            LEFT(0, -1, 2),
            DOWN(1, 0, 3),
            UP(-1, 0, 4);

            final int drow;
            final int dcol;
            final int sign;

            Direction(int drow, int dcol, int sign) {
                this.drow = drow;
                this.dcol = dcol;
                this.sign = sign;
            }
        }

        private record Cell(int row, int col, int cost) {
        }
    }

    class MinimumCostToMakeAtLeastOneValidPathInGridRev2 implements MinimumCostToMakeAtLeastOneValidPathInGrid {

        @Override
        public int minCost(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            // 0-1 BFS
            final var q = new ArrayDeque<Cell>();

            final var costs = new int[m][n];
            for (var items : costs) {
                Arrays.fill(items, Integer.MAX_VALUE);
            }

            q.offer(new Cell(0, 0));
            costs[0][0] = 0;
            while (!q.isEmpty()) {
                var curr = q.poll();

                if (curr.row == m - 1 && curr.col == n - 1) {
                    return costs[m - 1][n - 1];
                }

                for (Direction d : Direction.values()) {
                    final var nextRow = curr.row + d.drow;
                    final var nextCol = curr.col + d.dcol;

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    final var delta = (d.sign == grid[curr.row][curr.col]) ? 0 : 1;
                    if (costs[curr.row][curr.col] + delta < costs[nextRow][nextCol]) {
                        final var next = new Cell(nextRow, nextCol);
                        if (delta == 0) {
                            q.offerFirst(next);
                        } else {
                            q.offerLast(next);
                        }
                        costs[nextRow][nextCol] = costs[curr.row][curr.col] + delta;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }

        private enum Direction {
            RIGHT(0, 1, 1),
            LEFT(0, -1, 2),
            DOWN(1, 0, 3),
            UP(-1, 0, 4);

            final int drow;
            final int dcol;
            final int sign;

            Direction(int drow, int dcol, int sign) {
                this.drow = drow;
                this.dcol = dcol;
                this.sign = sign;
            }
        }

        private record Cell(int row, int col) {
        }
    }
}
