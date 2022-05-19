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

    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    // DFS with memoization
    //
    // Time complexity : O(M*N). Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once.
    // The total time complexity is then O(V+E). V is the total number of vertices and E is the total number of edges.
    // In our problem, O(V) = O(M*N), O(E) = O(4V) = O(M*N).
    //
    // Space complexity : O(M*N). The cache dominates the space complexity.
    public int longestIncreasingPath(int[][] matrix) {
        // memo[i][j] - longest increasing path starting at matrix[i][j]
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        int ans = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                ans = Math.max(ans, dfs(matrix, row, col, memo));
            }
        }
        return ans;
    }

    // Returns the length of the longest increasing path starting at (row, col)
    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        // already solved?
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // take the longest increasing path length by moving left, right, up, down
        int best = 1;
        for (int[] d : DIRECTIONS) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];

            // check boundaries
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                continue;
            }

            // check if the next element can be appended to the current increasing path
            if (matrix[nextRow][nextCol] > matrix[row][col]) {
                best = Math.max(best, 1 + dfs(matrix, nextRow, nextCol, memo));
            }
        }

        // cache and return the answer to a sub-problem
        return memo[row][col] = best;
    }
}
