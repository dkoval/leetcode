package com.github.dkoval.leetcode.interview.trees;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3072/">Longest Increasing Path in a Matrix</a>
 * <p>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 */
public class LongestIncreasingPathInMatrix {

    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    // DFS with memoization
    //
    // Time complexity : O(M*N). Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once.
    // The total time complexity is then O(V+E). V is the total number of vertices and E is the total number of edges.
    // In our problem, O(V) = O(M*N), O(E) = O(4V) = O(M*N).
    //
    // Space complexity : O(M*N). The cache dominates the space complexity.
    public int longestIncreasingPath(int[][] matrix) {
        // memo[i][j] - longest increasing path starting at matrix[i][j]
        int[][] memo = new int[matrix.length][matrix[0].length];

        int result = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, dfs(matrix, i, j, memo));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int longestIncPathSoFar = 0;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            // boundary check
            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) {
                continue;
            }

            // check if the next element can be appended to the current increasing path
            if (matrix[nextRow][nextCol] <= matrix[row][col]) {
                continue;
            }

            // take the longest increasing path length by moving left, right, up, down
            longestIncPathSoFar = Math.max(longestIncPathSoFar, dfs(matrix, nextRow, nextCol, memo));
        }

        return memo[row][col] = longestIncPathSoFar + 1;
    }
}
