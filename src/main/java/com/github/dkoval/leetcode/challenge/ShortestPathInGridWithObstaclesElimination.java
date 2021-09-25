package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3987/">Shortest Path in a Grid with Obstacles Elimination</a>
 * <p>
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle).
 * You can move up, down, left, or right from and to an empty cell in one step.
 * <p>
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1)
 * given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 40</li>
 *  <li>1 <= k <= m * n</li>
 *  <li>grid[i][j] == 0 or 1</li>
 *  <li>grid[0][0] == grid[m - 1][n - 1] == 0</li>
 * </ul>
 */
public class ShortestPathInGridWithObstaclesElimination {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static class State {
        final int row;
        final int col;
        final int k;

        State(int row, int col, int k) {
            this.row = row;
            this.col = col;
            this.k = k;
        }

        public int hashCode() {
            return Objects.hash(row, col, k);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != State.class) {
                return false;
            }
            State that = (State) obj;
            return (row == that.row) && (col == that.col) && (k == that.k);
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return 0;
        }

        State start = new State(0, 0, 0);

        // Keep track of distances
        Map<State, Integer> dists = new HashMap<>();
        dists.put(start, 0);

        // BFS
        Queue<State> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            State curr = q.poll();
            int dist = dists.get(curr);
            for (int[] d : DIRECTIONS) {
                int nextRow = curr.row + d[0];
                int nextCol = curr.col + d[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                    int nextK = curr.k + grid[nextRow][nextCol];
                    if (nextK > k) {
                        continue;
                    }

                    State next = new State(nextRow, nextCol, nextK);
                    if (dists.containsKey(next)) {
                        continue;
                    }

                    if (nextRow == m - 1 && nextCol == n - 1) {
                        return dist + 1;
                    }

                    dists.put(next, dist + 1);
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}
