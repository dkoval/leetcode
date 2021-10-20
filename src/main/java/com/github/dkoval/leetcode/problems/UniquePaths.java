package com.github.dkoval.leetcode.problems;

public interface UniquePaths {

    int uniquePaths(int m, int n);

    class UniquePathsDPTopDown implements UniquePaths {

        @Override
        public int uniquePaths(int m, int n) {
            return uniquePaths(m, n, 0, 0, new Integer[m][n]);
        }

        private int uniquePaths(int m, int n, int row, int col, Integer[][] memo) {
            if (row == m - 1 && col == n - 1) {
                return 1;
            }

            if (row >= m || col >= n) {
                return 0;
            }

            if (memo[row][col] != null) {
                return memo[row][col];
            }

            memo[row][col] = uniquePaths(m, n, row + 1, col, memo) + uniquePaths(m, n, row, col + 1, memo);
            return memo[row][col];
        }
    }
}
