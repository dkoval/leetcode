package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/jump-game-v/">Jump Game V</a>
 * <p>
 * Given an array of integers arr and an integer d. In one step you can jump from index i to index:
 * <p>
 * i + x where: i + x < arr.length and  0 < x <= d.
 * i - x where: i - x >= 0 and  0 < x <= d.
 * In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).
 * <p>
 * You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 1000</li>
 *  <li>1 <= arr[i] <= 10^5</li>
 *  <li>1 <= d <= arr.length</li>
 * </ul>
 */
public interface JumpGame5 {

    int maxJumps(int[] arr, int d);

    class JumpGame5Rev1 implements JumpGame5 {

        @Override
        public int maxJumps(int[] arr, int d) {
            final var n = arr.length;

            // good[i][j] - whether j index is reachable starting from i
            final boolean[][] good = new boolean[n][n];
            for (var i = 0; i < n; i++) {
                for (var j = i + 1; j < n; j++) {
                    if (arr[i] <= arr[j]) {
                        // j, j + 1, ..., n aren't reachable from i
                        break;
                    }
                    good[i][j] = true;
                }
            }

            for (var i = 0; i < n; i++) {
                for (var j = i - 1; j >= 0; j--) {
                    if (arr[i] <= arr[j]) {
                        // j, j - 1, ..., 0 aren't reachable from i
                        break;
                    }
                    good[i][j] = true;
                }
            }

            final int[] dp = new int[n];
            Arrays.fill(dp, -1);

            var best = 0;
            for (var i = 0; i < n; i++) {
                best = Math.max(best, 1 + calc(arr, d, i, good, dp));
            }
            return best;
        }

        private int calc(int[] arr, int d, int index, boolean[][] good, int[] dp) {
            final var n = arr.length;

            if (dp[index] >= 0) {
                return dp[index];
            }

            var best = 0;
            for (var delta = 1; delta <= d; delta++) {
                if (index + delta < n && good[index][index + delta]) {
                    best = Math.max(best, 1 + calc(arr, d, index + delta, good, dp));
                }

                if (index - delta >= 0 && good[index][index - delta]) {
                    best = Math.max(best, 1 + calc(arr, d, index - delta, good, dp));
                }
            }
            return dp[index] = best;
        }
    }

    class JumpGame5Rev2 implements JumpGame5 {

        @Override
        public int maxJumps(int[] arr, int d) {
            final var n = arr.length;

            final var dp = new int[n];
            Arrays.fill(dp, -1);

            // try every possible starting index
            var best = 1;
            for (var i = 0; i < n; i++) {
                best = Math.max(best, dfs(arr, d, i, dp));
            }
            return best;
        }

        private int dfs(int[] arr, int d, int i, int[] dp) {
            final var n = arr.length;

            // already solved?
            if (dp[i] >= 0) {
                return dp[i];
            }

            var best = 1;

            // go right from index i
            for (var j = i + 1; j <= Math.min(i + d, n - 1); j++) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                best = Math.max(best, 1 + dfs(arr, d, j, dp));
            }

            // go left from index i
            for (var j = i - 1; j >= Math.max(i - d, 0); j--) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                best = Math.max(best, 1 + dfs(arr, d, j, dp));
            }

            return dp[i] = best;
        }
    }
}
