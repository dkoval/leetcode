package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3831/">01 Matrix</a>
 * <p>
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix {

    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static final int UNKNOWN_DISTANCE = -1;

    private static class Cell {
        final int row;
        final int col;
        final int distance;

        Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    // O(M * N) time | O(M * N) space
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // init result matrix
        int[][] result = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = UNKNOWN_DISTANCE;
            }
        }

        // step #1: collect 0-cells in the given binary matrix
        Queue<Cell> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    result[row][col] = 0;
                    q.offer(new Cell(row, col, 0));
                }
            }
        }

        // step #2: run BFS (BFS guarantees the shortest path from source to destination)
        while (!q.isEmpty()) {
            Cell curr = q.poll();
            for (int[] d : DIRECTIONS) {
                int nextRow = curr.row + d[0];
                int nextCol = curr.col + d[1];
                if (nextRow >= 0 && nextRow < m
                        && nextCol >= 0 && nextCol < n
                        && result[nextRow][nextCol] == UNKNOWN_DISTANCE) {
                    int distance = curr.distance + 1;
                    result[nextRow][nextCol] = distance;
                    q.offer(new Cell(nextRow, nextCol, distance));
                }
            }
        }

        return result;
    }
}
