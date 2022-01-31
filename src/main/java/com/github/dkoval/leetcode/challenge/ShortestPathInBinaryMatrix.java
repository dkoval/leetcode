package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3638/">Shortest Path in Binary Matrix</a>
 * <p>
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * <p>
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 * <ul>
 *  <li>Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)</li>
 *  <li>C_1 is at location (0, 0) (ie. has value grid[0][0])</li>
 *  <li>C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])</li>
 *  <li>If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).</li>
 * </ul>
 * Return the length of the shortest such clear path from top-left to bottom-right. If such a path does not exist, return -1.
 */
public class ShortestPathInBinaryMatrix {

    private static class Cell {
        final int row;
        final int col;
        final int distance;

        private Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    // O(N^2) time | O(N^2) space
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // BFS
        Queue<Cell> queue = new LinkedList<>();
        enqueue(queue, grid, 0, 0, 1);
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (cell.row == n - 1 && cell.col == n - 1) {
                return cell.distance;
            }
            // 8-directionally adjacent cells
            for (int dy = -1; dy <= 1; dy++) {
                for (int dx = -1; dx <= 1; dx++) {
                    int nextRow = cell.row + dy;
                    int nextCol = cell.col + dx;
                    enqueue(queue, grid, nextRow, nextCol, cell.distance + 1);
                }
            }
        }
        return -1;
    }

    private void enqueue(Queue<Cell> queue, int[][] grid, int row, int col, int distance) {
        int n = grid.length;
        if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0) {
            grid[row][col] = -1; // mark current cell as visited
            queue.offer(new Cell(row, col, distance));
        }
    }
}
