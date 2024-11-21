package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/count-unguarded-cells-in-the-grid/">Count Unguarded Cells in the Grid</a>
 * <p>
 * You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays
 * guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of
 * the ith guard and jth wall respectively.
 * <p>
 * A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position
 * unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
 * <p>
 * Return the number of unoccupied cells that are not guarded.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m, n <= 10^5</li>
 *  <li>2 <= m * n <= 10^5</li>
 *  <li>1 <= guards.length, walls.length <= 5 * 10^4</li>
 *  <li>2 <= guards.length + walls.length <= m * n</li>
 *  <li>guards[i].length == walls[j].length == 2</li>
 *  <li>0 <= rowi, rowj < m</li>
 *  <li>0 <= coli, colj < n</li>
 *  <li>All the positions in guards and walls are unique.</li>
 * </ul>
 */
public interface CountUnguardedCellsInGrid {

    int countUnguarded(int m, int n, int[][] guards, int[][] walls);

    class CountUnguardedCellsInGridRev1 implements CountUnguardedCellsInGrid {

        private static final char GUARD = 'G';
        private static final char WALL = 'W';
        // Directions: up, down, left, right
        private static final List<Direction> DIRS = Arrays.asList(
                new Direction(-1, 0),
                new Direction(1, 0),
                new Direction(0, -1),
                new Direction(0, 1)
        );

        @Override
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            char[][] grid = new char[m][n];

            for (int[] wall : walls) {
                grid[wall[0]][wall[1]] = WALL;
            }

            for (int[] guard : guards) {
                grid[guard[0]][guard[1]] = GUARD;
                // for each guard, explore 4 cardinal directions
                for (Direction d : DIRS) {
                    int row = guard[0] + d.dx;
                    int col = guard[1] + d.dy;
                    while (row >= 0 && row < m && col >= 0 && col < n) {
                        if (grid[row][col] == GUARD || grid[row][col] == WALL || grid[row][col] == d.marker()) {
                            break;
                        }

                        // mark current cell as guarded
                        if (grid[row][col] == 0) {
                            grid[row][col] = d.marker();
                        }

                        // prepare for the next iteration
                        row += d.dx;
                        col += d.dy;
                    }
                }
            }

            int count = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 0) {
                        count++;
                    }
                }
            }
            return count;
        }

        private record Direction(int dx, int dy) {

            char marker() {
                return (dx == 0) ? '-' : '|';
            }
        }
    }
}
