package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/stone-game-iv/">Stone Game IV</a>
 * <p>
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there are n stones in a pile.  On each player's turn, that player makes a move consisting of removing
 * any non-zero square number of stones in the pile.
 * <p>
 * Also, if a player cannot make a move, he/she loses the game.
 * <p>
 * Given a positive integer n. Return True if and only if Alice wins the game otherwise return False,
 * assuming both players play optimally.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 */
public interface StoneGame4 {

    boolean winnerSquareGame(int n);

    // Time complexity: O(N^1.5)
    // Space complexity: O(N)
    class StoneGame4DPTopDown implements StoneGame4 {

        @Override
        public boolean winnerSquareGame(int n) {
            // DP top-down
            return calc(n, new Boolean[n + 1]);
        }

        private boolean calc(int n, Boolean[] dp) {
            // base case
            if (n == 0) {
                return false;
            }

            // already solved?
            if (dp[n] != null) {
                return dp[n];
            }

            var aliceWins = false;
            for (var i = 1; i * i <= n; i++) {
                // Now, it's Bob's turn. If Bob loses, Alice wins.
                if (!calc(n - i * i, dp)) {
                    aliceWins = true;
                    break;
                }
            }

            // cache and return the result
            return dp[n] = aliceWins;
        }
    }

    // Time complexity: O(N^1.5)
    // Space complexity: O(N)
    class StoneGame4DPBottomUp implements StoneGame4 {

        @Override
        public boolean winnerSquareGame(int n) {
            final var dp = new boolean[n + 1];
            for (var i = 1; i <= n; i++) {
                for (var j = 1; j * j <= i; j++) {
                    // Simulate Bob's turns. If Bob loses, Alice wins.
                    if (!dp[i - j * j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
