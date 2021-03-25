package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3684/">Pacific Atlantic Water Flow</a>
 * <p>
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 */
public class PacificAtlanticWaterFlow {

    private static final int DUMMY_PREV_VALUE = -1;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return Collections.emptyList();
        }

        int n = matrix[0].length;
        if (n == 0) {
            return Collections.emptyList();
        }

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, DUMMY_PREV_VALUE, pacific); // 1st row
            dfs(matrix, m - 1, j, DUMMY_PREV_VALUE, atlantic); // last row
        }

        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, DUMMY_PREV_VALUE, pacific); // 1st column
            dfs(matrix, i, n - 1, DUMMY_PREV_VALUE, atlantic); // last column
        }

        // merge individual results
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int row, int col, int prev, boolean[][] visited) {
        // boundary check
        if (row == -1 || row == matrix.length || col == -1 || col == matrix[0].length) {
            return;
        }

        // state transition check
        if (matrix[row][col] < prev || visited[row][col]) {
            return;
        }

        // mark cell (row, col) as visited
        visited[row][col] = true;

        // call DFS for allowed direction
        for (int[] dir : DIRS) {
            dfs(matrix, row + dir[0], col + dir[1], matrix[row][col], visited);
        }
    }
}