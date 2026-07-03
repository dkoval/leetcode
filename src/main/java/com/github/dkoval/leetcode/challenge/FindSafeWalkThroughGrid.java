package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-a-safe-walk-through-a-grid/">Find a Safe Walk Through a Grid</a>
 * <p>
 * You are given an m x n binary matrix grid and an integer health.
 * <p>
 * You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).
 * <p>
 * You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.
 * <p>
 * Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.
 * <p>
 * Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 50</li>
 *  <li>2 <= m * n</li>
 *  <li>1 <= health <= m + n</li>
 *  <li>grid[i][j] is either 0 or 1.</li>
 * </ul>
 */
public interface FindSafeWalkThroughGrid {

    boolean findSafeWalk(List<List<Integer>> grid, int health);

    class FindSafeWalkThroughGridRev1 implements FindSafeWalkThroughGrid {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public boolean findSafeWalk(List<List<Integer>> grid, int health) {
            final var m = grid.size();
            final var n = grid.get(0).size();

            // Dijkstra
            final var q = new PriorityQueue<Node>(Comparator.comparingInt(Node::cost));
            final var dists = new int[m][n];
            for (var row : dists) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            q.offer(new Node(0, 0, grid.get(0).get(0)));
            dists[0][0] = grid.get(0).get(0);
            while (!q.isEmpty()) {
                final var curr = q.poll();

                // reached the target?
                if (curr.row == m - 1 && curr.col == n - 1) {
                    return health > curr.cost;
                }

                for (var d : DIRS) {
                    final var nextRow = curr.row + d[0];
                    final var nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    // can move?
                    final var nextCost = curr.cost + grid.get(nextRow).get(nextCol);
                    if (nextCost < dists[nextRow][nextCol]) {
                        q.offer(new Node(nextRow, nextCol, nextCost));
                        dists[nextRow][nextCol] = nextCost;
                    }
                }
            }
            return false;
        }

        private record Node(int row, int col, int cost) {
        }
    }
}
