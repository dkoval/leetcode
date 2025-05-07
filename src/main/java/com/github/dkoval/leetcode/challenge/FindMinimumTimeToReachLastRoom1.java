package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/">Find Minimum Time to Reach Last Room I</a>
 * <p>
 * There is a dungeon with n x m rooms arranged as a grid.
 * <p>
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when
 * you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room.
 * Moving between adjacent rooms takes exactly one second.
 * <p>
 * Return the minimum time to reach the room (n - 1, m - 1).
 * <p>
 * Two rooms are adjacent if they share a common wall, either horizontally or vertically.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n == moveTime.length <= 50</li>
 *  <li>2 <= m == moveTime[i].length <= 50</li>
 *  <li>0 <= moveTime[i][j] <= 10^9</li>
 * </ul>
 */
public interface FindMinimumTimeToReachLastRoom1 {

    int minTimeToReach(int[][] moveTime);

    class FindMinimumTimeToReachLastRoom1Rev1 implements FindMinimumTimeToReachLastRoom1 {

        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int minTimeToReach(int[][] moveTime) {
            final var m = moveTime.length;
            final var n = moveTime[0].length;

            final var source = new Cell(0, 0);

            // Dijkstra's algorithm
            final var q = new PriorityQueue<>(Comparator.comparingInt(Node::time));
            final var best = new HashMap<Cell, Integer>();
            q.offer(new Node(source, 0));
            best.put(source, 0);

            while (!q.isEmpty()) {
                final var curr = q.poll();

                if (curr.cell.row == m - 1 && curr.cell.col == n - 1) {
                    return curr.time;
                }

                for (var d : DIRS) {
                    final var nextRow = curr.cell.row + d[0];
                    final var nextCol = curr.cell.col + d[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    final var next = new Cell(nextRow, nextCol);
                    final var time = Math.max(curr.time, moveTime[nextRow][nextCol]) + 1;

                    if (best.getOrDefault(next, Integer.MAX_VALUE) > time) {
                        best.put(next, time);
                        q.offer(new Node(next, time));
                    }
                }
            }
            return -1;
        }

        private record Cell(int row, int col) {
        }

        private record Node(Cell cell, int time) {
        }
    }
}
