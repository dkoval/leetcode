package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/number-of-paths-with-max-score/">Number of Paths with Max Score</a>
 * <p>
 * You are given a square board of characters. You can move on the board starting at the bottom right square marked with the character 'S'.
 * <p>
 * You need to reach the top left square marked with the character 'E'. The rest of the squares are labeled either with a numeric character 1, 2, ..., 9 or with an obstacle 'X'.
 * In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.
 * <p>
 * Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect,
 * and the second is the number of such paths that you can take to get that maximum sum, taken modulo 10^9 + 7.
 * <p>
 * In case there is no path, return [0, 0].
 */
public interface NumberOfPathsWithMaxScore {

    int MOD = 1_000_000_007;

    int[] pathsWithMaxScore(List<String> board);

    class NumberOfPathsWithMaxScoreRev1 implements NumberOfPathsWithMaxScore {

        private static final int[][] DIRS = {{-1, 0}, {0, -1}, {-1, -1}};

        @Override
        public int[] pathsWithMaxScore(List<String> board) {
            final var m = board.size();
            final var n = board.get(0).length();

            // DP (bottom-up)
            final var dp = new int[m][n];
            final var counts = new int[m][n];

            // base case
            counts[m - 1][n - 1] = 1;
            for (var row = m - 1; row >= 0; row--) {
                for (var col = n - 1; col >= 0; col--) {
                    // is an obstacle?
                    if (counts[row][col] == 0) {
                        continue;
                    }

                    for (var d : DIRS) {
                        final var nextRow = row + d[0];
                        final var nextCol = col + d[1];

                        if (nextRow >= 0 && nextCol >= 0 && board.get(nextRow).charAt(nextCol) != 'X') {
                            final var delta = delta(board.get(nextRow).charAt(nextCol));
                            final var nextScore = dp[row][col] + delta;

                            if (nextScore > dp[nextRow][nextCol]) {
                                dp[nextRow][nextCol] = nextScore;
                                counts[nextRow][nextCol] = counts[row][col];
                            } else if (nextScore == dp[nextRow][nextCol]) {
                                counts[nextRow][nextCol] += counts[row][col];
                                counts[nextRow][nextCol] %= MOD;
                            }
                        }
                    }
                }
            }
            return new int[]{dp[0][0], counts[0][0]};
        }

        private int delta(char c) {
            return (c >= '0' && c <= '9') ? c - '0' : 0;
        }
    }
}
