package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/">Nearest Exit from Entrance in Maze</a>
 * <p>
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
 * You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 * <p>
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze.
 * Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze.
 * The entrance does not count as an exit.
 * <p>
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 * <p>
 * Constraints:
 * <ul>
 *  <li>maze.length == m</li>
 *  <li>maze[i].length == n</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>maze[i][j] is either '.' or '+'</li>
 *  <li>entrance.length == 2</li>
 *  <li>0 <= entrancerow < m</li>
 *  <li>0 <= entrancecol < n</li>
 *  <li>entrance will always be an empty cell</li>
 * </ul>
 */
public interface NearestExitFromEntranceInMaze {

    int nearestExit(char[][] maze, int[] entrance);

    class NearestExitFromEntranceInMazeUsingBFS implements NearestExitFromEntranceInMaze {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        @Override
        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length;
            int n = maze[0].length;

            int startRow = entrance[0];
            int startCol = entrance[1];

            Queue<Cell> q = new ArrayDeque<>();
            maze[startRow][startCol] = '#'; // mark as visited
            q.offer(new Cell(startRow, startCol));
            int dist = 0;
            while (!q.isEmpty()) {
                // number of cells on the current level
                int size = q.size();
                while (size-- > 0) {
                    // number of cell at the current level
                    Cell curr = q.poll();
                    for (int[] d : DIRS) {
                        int nextRow = curr.row + d[0];
                        int nextCol = curr.col + d[1];

                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || maze[nextRow][nextCol] != '.') {
                            continue;
                        }

                        if (nextRow == 0 || nextRow == m - 1 || nextCol == 0 || nextCol == n - 1) {
                            return dist + 1;
                        }

                        maze[nextRow][nextCol] = '#';
                        q.offer(new Cell(nextRow, nextCol));
                    }
                }
                dist++;
            }
            return -1;
        }
    }
}
