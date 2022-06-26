package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a>
 * <p>
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == mat.length</li>
 *  <li>n == mat[i].length</li>
 *  <li>1 <= m, n <= 10^4</li>
 *  <li>1 <= m * n <= 10^4</li>
 *  <li>mat[i][j] is either 0 or 1</li>
 *  <li>There is at least one 0 in mat</li>
 * </ul>
 */
public class ZeroOneMatrix {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static class Cell {
        final int row;
        final int col;
        final int dist;

        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    // O(M * N) time | O(M * N) space
    public int[][] updateMatrix(int[][] mat) {
        // Idea: run multi BFS from 0's
        int m = mat.length;
        int n = mat[0].length;

        // step #1: collect 0's
        Queue<Cell> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    q.offer(new Cell(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        // step #2: run BFS (BFS guarantees the shortest path from source to destination)
        int[][] ans = new int[m][n];
        while (!q.isEmpty()) {
            Cell curr = q.poll();
            for (int[] d : DIRS) {
                int nextRow = curr.row + d[0];
                int nextCol = curr.col + d[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                    continue;
                }

                if (mat[nextRow][nextCol] == 1) {
                    ans[nextRow][nextCol] = curr.dist + 1;
                }

                q.offer(new Cell(nextRow, nextCol, curr.dist + 1));
                visited[nextRow][nextCol] = true;
            }
        }
        return ans;
    }
}
