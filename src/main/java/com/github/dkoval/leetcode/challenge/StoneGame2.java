package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/stone-game-ii/">Stone Game II</a>
 * <p>
 * Alice and Bob continue their games with piles of stones.
 * There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * The objective of the game is to end with the most stones.
 * <p>
 * Alice and Bob take turns, with Alice starting first. Initially, M = 1.
 * <p>
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.
 * Then, we set M = max(M, X).
 * <p>
 * The game continues until all the stones have been taken.
 * <p>
 * Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 */
public interface StoneGame2 {

    int stoneGameII(int[] piles);

    class StoneGame2DPTopDown implements StoneGame2 {

        @Override
        public int stoneGameII(int[] piles) {
            int n = piles.length;

            // DP top-down
            // 0 -> Alice
            // 1 -> Bob
            Integer[][][] dp = new Integer[2][n][n + 1];
            return calculate(piles, 0, 0, 1, dp);
        }

        private int calculate(int[] piles, int idx, int player, int m, Integer[][][] dp) {
            int n = piles.length;

            if (idx >= n) {
                return 0;
            }

            // already solved?
            if (dp[player][idx][m] != null) {
                return dp[player][idx][m];
            }

            // Alice's score
            boolean alice = player == 0;
            int best = alice ? 0 : Integer.MAX_VALUE;
            int total = 0;
            for (int x = 1; x <= 2 * m; x++) {
                if (idx + x - 1 == n) {
                    break;
                }

                total += piles[idx + x - 1];
                // Alice's future score
                int score = calculate(piles, idx + x, (player + 1) % 2, Math.max(m, x), dp);
                // Both Alice and Bob play optimally, therefore
                // Alice's strategy is to maximize her own score, whereas Bob tries to minimize Alice's score
                best = alice ? Math.max(best, total + score) : Math.min(best, score);
            }
            return dp[player][idx][m] = best;
        }
    }
}
